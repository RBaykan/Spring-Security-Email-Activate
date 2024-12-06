package com.nontius.proje.service;

import org.springframework.stereotype.Service;

import com.nontius.proje.model.User;
import com.nontius.proje.model.VerifiticationToken;

@Service
public interface VerifiticationTokenService {

	VerifiticationToken getToken(String token);
	VerifiticationToken createToken(User user, String token);
}
