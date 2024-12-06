package com.nontius.proje.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.nontius.proje.dto.UserDTO;
import com.nontius.proje.model.User;
import com.nontius.proje.model.VerifiticationToken;


@Service
public interface UserService {
	List<UserDTO> getAllUser();
	UserDTO registerNewUser(UserDTO user);
	String confirmRegistration(String token);


}
