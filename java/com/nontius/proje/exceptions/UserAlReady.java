package com.nontius.proje.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "This user already exits" )
public class UserAlReady extends RuntimeException{
	
	
	

}
