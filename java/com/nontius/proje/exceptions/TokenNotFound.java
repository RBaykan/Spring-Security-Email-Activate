package com.nontius.proje.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Token Not Found" )
public class TokenNotFound extends RuntimeException{
	
	
	

}
