package com.nontius.proje.configuration;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfiguration {
	
	/*
	@Bean
	public JavaMailSender javaMailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		
		mailSender.setHost("smtp.elasticemail.com");
		mailSender.setPort(2525);
		
		
		mailSender.setUsername("deneme@deneme.com");
		mailSender.setPassword("0FC10F8A5F3A51E626E14D4E64441B006056");
		
		

        return mailSender;
		
		
	}*/

}
