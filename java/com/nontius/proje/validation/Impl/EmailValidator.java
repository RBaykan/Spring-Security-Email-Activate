package com.nontius.proje.validation.Impl;


import java.util.regex.Pattern;

import com.nontius.proje.validation.EmailValid;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<EmailValid, String>{

	private Pattern pattern;
	private static final String EMAIL_PATTERN = 
		    "^[_A-Za-z0-9-+]+(\\.[_A-Za-z0-9-]+)*@" +
		    "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	
	@Override
	public void initialize(EmailValid valid) {
		// Özel başlatma seçenekleri burada başlar
	}
	
	@Override
	//ConstraintValidator<EmailValid, T> -> value = T
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value == null) return false; // null kontrolü
        pattern = Pattern.compile(EMAIL_PATTERN);
        return pattern.matcher(value).matches(); // Email deseni kontrolü
	}

}
