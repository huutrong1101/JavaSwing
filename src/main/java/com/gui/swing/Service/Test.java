package com.gui.swing.Service;

import com.gui.swing.DTO.Request.ChangePasswordRequest;
import com.gui.swing.DTO.Request.SendEmailRequest;
import com.gui.swing.DTO.Response.GeneralResponse;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class Test {

    @Autowired
    AuthenticationService authenticationService;

    @Autowired
    EmailService emailService;

    public void testLogin(){
        System.out.println(authenticationService.authentication("giangnam17122002@gmail.com","giangnam123").getMessage());

    }
    public void testSendEmail() throws MessagingException {
        Map<String,Object> context = new HashMap<>();
        context.put("text",123);
        GeneralResponse generalResponse = emailService.sendMessageUsingThymeleafTemplate(new SendEmailRequest("giangnam.17122002@gmail.com", "Confirmation code", context));
        System.out.println(generalResponse.getMessage());
    }

    public void testForgetPassword() throws MessagingException {
        GeneralResponse generalResponse = authenticationService.forgetPassword("giangnam.17122002@gmail.com");
        System.out.println(authenticationService.confirmOTPCode("giangnam.17122002@gmail.com",123456) ? "Mã xác nhận đúng" : "Mã xác nhận sai");
    }

    public void testChangePassword(){
        GeneralResponse generalResponse = authenticationService.changePassword(new ChangePasswordRequest("huutrong1101@gmail.com","Giangnam1@","Giangnam1@"));
        System.out.println(generalResponse);
    }
}
