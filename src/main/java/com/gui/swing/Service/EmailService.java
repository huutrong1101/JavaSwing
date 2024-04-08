package com.gui.swing.Service;

import com.gui.swing.DTO.Request.SendEmailRequest;
import com.gui.swing.DTO.Response.GeneralResponse;
import jakarta.mail.MessagingException;
import jakarta.mail.SendFailedException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import java.util.Map;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender emailSender;

    @Autowired
    private SpringTemplateEngine thymeleafTemplateEngine;

    public void sendSimpleMessage(String from, String to, String subject, String text){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        emailSender.send(message);
    }

    public void sendMessageWithTemplate(String to, String subject, String htmlBody) throws MessagingException {
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(htmlBody, true);
        emailSender.send(mimeMessage);
    }

    public GeneralResponse sendMessageUsingThymeleafTemplate(SendEmailRequest sendEmailRequest) throws MessagingException, SendFailedException {
        try {
            Context thymeleafContext = new Context();
            thymeleafContext.setVariables(sendEmailRequest.getContext());
            String htmlBody = thymeleafTemplateEngine.process("template-thymeleaf.html", thymeleafContext);
            sendMessageWithTemplate(sendEmailRequest.getToEmail(),sendEmailRequest.getSubject(), htmlBody);
        } catch(SendFailedException sendFailedException){
            return new GeneralResponse(-1, "Có lỗi xảy ra");
        }
        return new GeneralResponse(1,"Gửi email thành công!");
    }
}
