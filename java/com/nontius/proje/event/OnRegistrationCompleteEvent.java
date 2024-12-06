package com.nontius.proje.event;

import java.util.Locale;

import org.springframework.context.ApplicationEvent;

import com.nontius.proje.model.User;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class OnRegistrationCompleteEvent extends ApplicationEvent {
	private String appUrl;
	
	private User user;
	
	public OnRegistrationCompleteEvent(User user, String  appUrl) {
		super(user);
		
		this.user = user;
		this.appUrl = appUrl;
		
		
	}

}
