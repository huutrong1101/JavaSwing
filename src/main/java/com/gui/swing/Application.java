package com.gui.swing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		// Demo Simple Application
		JFrame f=new JFrame();
		SpringApplication.run(Application.class, args);
		//creating instance of JFrame

		JButton b=new JButton("click");//creating instance of JButton
		b.setBounds(130,100,100, 40);//x axis, y axis, width, height

		f.add(b);//adding button in JFrame

		f.setSize(400,500);//400 width and 500 height
		f.setLayout(null);//using no layout managers
		f.setVisible(true);//making the frame visible
	}

}
