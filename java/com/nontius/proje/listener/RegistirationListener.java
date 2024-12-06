package com.nontius.proje.listener;

import java.util.UUID;

import org.springframework.context.ApplicationListener;
import org.springframework.context.MessageSource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.nontius.proje.event.OnRegistrationCompleteEvent;
import com.nontius.proje.model.User;
import com.nontius.proje.service.UserService;
import com.nontius.proje.service.VerifiticationTokenService;
import com.nontius.proje.service.Impl.VerifiticationTokenServiceImpl;

import lombok.AllArgsConstructor;

@Component
public class RegistirationListener implements ApplicationListener<OnRegistrationCompleteEvent>{


	private final VerifiticationTokenService service;
	
	private final MessageSource messages;
	
	private final JavaMailSender sender;
	
	public RegistirationListener(VerifiticationTokenService service,
			MessageSource messages, JavaMailSender sender) {
		
			this.service = service;
			this.messages = messages;
			this.sender = sender;
	}
	
	
	@Override
	public void onApplicationEvent(OnRegistrationCompleteEvent event) {
		
		this.confirmRegistration(event);
	}
	
	
	private void confirmRegistration(OnRegistrationCompleteEvent event) {
		
		User user = event.getUser();
		String token = UUID.randomUUID().toString();
		service.createToken(user, token);
		
		String recipientAdress = user.getEmail();
		String subject = "Registration Confirmation";
		
		String confirmationURL = event.getAppUrl() + "/registrationConfirm?token="+token;
		String message = messages.getMessage("message.RegSucc", null, null);
		
		SimpleMailMessage email = new SimpleMailMessage();
		email.setTo(recipientAdress);
		email.setSubject(subject);
		email.setText(message + "\r\n" + confirmationURL);
		sender.send(email);
	
	}

}
