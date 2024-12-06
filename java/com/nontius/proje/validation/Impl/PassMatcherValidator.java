package com.nontius.proje.validation.Impl;

import com.nontius.proje.dto.UserDTO;
import com.nontius.proje.validation.PasswordMatches;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PassMatcherValidator implements ConstraintValidator<PasswordMatches, UserDTO> {

	@Override
	public boolean isValid(UserDTO value, ConstraintValidatorContext context) {
		
		return value.getPassword().equals(value.getMachingPassword());
	}

	

}
