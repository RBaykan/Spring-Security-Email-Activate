package com.nontius.proje.service.Impl;

import org.springframework.stereotype.Service;

import com.nontius.proje.exceptions.TokenNotFound;
import com.nontius.proje.model.User;
import com.nontius.proje.model.VerifiticationToken;
import com.nontius.proje.repository.VerifiticationTokenRepository;
import com.nontius.proje.service.VerifiticationTokenService;


@Service
public class VerifiticationTokenServiceImpl implements VerifiticationTokenService {

	private final VerifiticationTokenRepository repository;
	
	public VerifiticationTokenServiceImpl(VerifiticationTokenRepository repository) {
		
		this.repository = repository;
	}
	
	
	@Override
	public VerifiticationToken getToken(String token) {
		
		try {
			return repository.findByToken(token);
		}catch(TokenNotFound e)  {
			return null;
		}
		
	}

	@Override
	public VerifiticationToken createToken(User user, String token) {
		VerifiticationToken t = new VerifiticationToken();
		
		t.setUser(user);
		t.setToken(token);
		
		return t;
		
	}

	
}
