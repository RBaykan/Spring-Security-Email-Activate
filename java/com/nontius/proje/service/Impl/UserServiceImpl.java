package com.nontius.proje.service.Impl;



import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import com.nontius.proje.dto.UserDTO;
import com.nontius.proje.event.OnRegistrationCompleteEvent;
import com.nontius.proje.exceptions.EmailAlReady;
import com.nontius.proje.exceptions.UserAlReady;
import com.nontius.proje.mapper.UserMapper;
import com.nontius.proje.model.User;
import com.nontius.proje.model.VerifiticationToken;
import com.nontius.proje.repository.UserRepository;
import com.nontius.proje.repository.VerifiticationTokenRepository;
import com.nontius.proje.service.UserService;


@Service
public class UserServiceImpl implements UserService{
	
	private final UserRepository userRepository;
	private final VerifiticationTokenRepository verifiticationTokenRepository;
	private final ApplicationEventPublisher publisher;
	
	public UserServiceImpl(UserRepository userRepository, 
			VerifiticationTokenRepository verifiticationTokenRepository,
			ApplicationEventPublisher publisher) {
		
		this.userRepository = userRepository;
		this.verifiticationTokenRepository = verifiticationTokenRepository;
		this.publisher = publisher;
	}
	
	

	@Override
	public List<UserDTO> getAllUser() {
		
		List<User> users = userRepository.findAll();
		return users.stream().map(
				(user) -> UserMapper.ModeltoDto(user)
				).collect(Collectors.toList());
	}


	@Override
	public UserDTO registerNewUser(UserDTO user) throws EmailAlReady, UserAlReady{
		
		if(emailExit(user.getEmail())) {
			
			
			throw new EmailAlReady();
			 
		}
		
		if(userExit(user.getUsername())) {
		
			throw new UserAlReady();
		}
		
		User newUser = UserMapper.DTOtoModel(user);
		
		userRepository.save(newUser);
		
		
		publisher.publishEvent(new OnRegistrationCompleteEvent(newUser, "http://localhost:8080/registrationConfirm"));
		
		return UserMapper.ModeltoDto(newUser);
		
	}
	

	
	private boolean emailExit(String email) {
	
		return userRepository.findByEmail(email) != null; 
		
	}
	
	

	
	private boolean userExit(String username) {
		
		return userRepository.findByUsername(username) != null; 
		
		
	}
	
	@Override
	public String confirmRegistration(String token){
		
		VerifiticationToken t = verifiticationTokenRepository.findByToken(token);
		
		if(t == null) {
			return "invaild token";
		}
		
		
		Calendar cal = Calendar.getInstance();
		
		if(t.getExpiryDate().getTime() - cal.getTime().getTime() <=0) {
			
			return "expired token";
		}
		
		User user = t.getUser();
		user.setEnabled(true);
		userRepository.save(user);
		
		return user.toString() + "Accounnt is enabled";
	}







}
