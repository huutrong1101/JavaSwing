package com.gui.swing.Service;

import com.gui.swing.DTO.Request.ChangePasswordRequest;
import com.gui.swing.DTO.Request.SendEmailRequest;
import com.gui.swing.DTO.Response.GeneralResponse;
import com.gui.swing.Entity.OTPCode;
import com.gui.swing.Entity.User;
import com.gui.swing.Repository.OTPCodeRepository;
import com.gui.swing.Repository.UserRepository;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class AuthenticationService {

    private final String regexEmail = "/(([^<>()\\[\\]\\\\.,;:\\s+@\"]+(\\.[^<>()\\[\\]\\\\.,;:\\s@\"]+)*)|(\".+\"))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))/mg";

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmailService emailService;

    private PasswordEncoder passwordEncoder;

    @Autowired
    private OTPCodeRepository otpCodeRepository;

    public AuthenticationService() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        passwordEncoder = bCryptPasswordEncoder;
    }


    public String encodePassword(String rawPassword) {
        return passwordEncoder.encode(rawPassword);
    }

    public GeneralResponse authentication(String username, String password){
        GeneralResponse authenticationMessage = new GeneralResponse();
        if (!ValidationService.validateEmail(username)){
            authenticationMessage.setStatus(-1);
            authenticationMessage.setMessage("Email không hợp lệ!");
            return authenticationMessage;
        }
        if (!ValidationService.existsUserByUserName(userRepository,username)){
            authenticationMessage.setStatus(-1);
            authenticationMessage.setMessage("Người dùng không tồn tại!");
            return authenticationMessage;
        }
        User user = userRepository.findByUserName(username);
        if (!passwordEncoder.matches(password,user.getUserPassword())){
            authenticationMessage.setStatus(-1);
            authenticationMessage.setMessage("Tài khoản hoặc mật khẩu không đúng!");
        }
        authenticationMessage.setStatus(ValidationService.isAdmin(user) ? 1 : 2);
        authenticationMessage.setMessage("Đăng nhập thành công!");
        return authenticationMessage;
    }

    public GeneralResponse forgetPassword(String email) throws MessagingException {
        GeneralResponse generalResponse = new GeneralResponse();
        System.out.println(email);
        if (!ValidationService.existsUserByUserName(userRepository,email)){
            generalResponse.setStatus(-1);
            generalResponse.setMessage("Người dùng không tồn tại!");
            return generalResponse;
        }
        int resultSendEmail = sendConfirmationCode(email);
        if (resultSendEmail == 0){
            generalResponse.setStatus(-1);
            generalResponse.setMessage("Có lỗi xảy ra trong quá trình gửi mail. Vui lòng thử lại!");
            return generalResponse;
        }
        OTPCode otpCode = new OTPCode();
        User user = userRepository.findByUserName(email);
        System.out.println(user.getUserId());
        otpCode.setCreatedTime(LocalDateTime.now());
        otpCode.setValue(resultSendEmail);
        otpCode.setUser(user);
        otpCode.setId(user.getUserId());
        otpCodeRepository.save(otpCode);
        generalResponse.setStatus(1);
        generalResponse.setMessage("Gửi mã xác nhận thành công!");
        return generalResponse;
    }

    public Boolean confirmOTPCode(String userName, int otpCode){
        if (!ValidationService.existsUserByUserName(userRepository,userName))
            return false;
        User user = userRepository.findByUserName(userName);
        return user.getOtpCode().getValue() == otpCode;
    }

    public int sendConfirmationCode(String email) throws MessagingException {
        Map<String,Object> context = new HashMap<>();
        int confirmationCode = GeneralService.generateConfirmationCode(100000,999999);
//        confirmationCode = 123456;
        context.put("ConfirmationCode",confirmationCode);
        GeneralResponse result = emailService.sendMessageUsingThymeleafTemplate(new SendEmailRequest(email,"Confirmation Code",context));
        return result.getStatus() == 1 ? confirmationCode : 0;
    }

    public GeneralResponse changePassword(ChangePasswordRequest changePasswordRequest){
        GeneralResponse generalResponse = new GeneralResponse();
        if (!ValidationService.validateEmail(changePasswordRequest.getUserName())){
            generalResponse.setStatus(-1);
            generalResponse.setMessage("Email không hợp lệ");
        }
        if (!ValidationService.existsUserByUserName(userRepository, changePasswordRequest.getUserName())){
            generalResponse.setStatus(-1);
            generalResponse.setMessage("Người dùng không tồn tại!");
            return generalResponse;
        }
        User user = userRepository.findByUserName(changePasswordRequest.getUserName());
        if (!changePasswordRequest.getNewPassword().equals(changePasswordRequest.getConfirmNewPassword())){
            generalResponse.setStatus(-1);
            generalResponse.setMessage("Mật khẩu và xác nhận mật khẩu không trùng nhau!");
        }
        user.setUserPassword(encodePassword(changePasswordRequest.getNewPassword()));
        userRepository.save(user);
        generalResponse.setStatus(1);
        generalResponse.setMessage("Đặt lại mật khẩu thành công!");
        return generalResponse;
    }
}
