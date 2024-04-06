package com.gui.swing;

import com.gui.swing.DTO.Request.SendEmailRequest;
import com.gui.swing.Service.EmailService;
import com.gui.swing.Service.Test;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication(scanBasePackages = { "com.gui.swing.Config", "com.gui.swing.Repository", "com.gui.swing.Service"})
public class Application {

	@Autowired
	private Test test;

	@Autowired
	private EmailService emailService;

	public static void main(String[] args) {
		// Demo Simple Application
		JFrame f=new JFrame();
		SpringApplication.run(Application.class, args);
//		creating instance of JFrame

		JButton b=new JButton("click");//creating instance of JButton
		b.setBounds(130,100,100, 40);//x axis, y axis, width, height

		f.add(b);//adding button in JFrame

		f.setSize(400,500);//400 width and 500 height
		f.setLayout(null);//using no layout managers
		f.setVisible(true);//making the frame visible
	}

	@Bean
	public CommandLineRunner demo() throws MessagingException {
//		test.testLogin();
//		test.testSendEmail();
//		test.testForgetPassword();
		test.testChangePassword();
		return (args) ->{
			System.out.println(1);
		};
	}

}
