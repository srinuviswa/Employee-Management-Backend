package com.web.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.config.JwtProvider;
import com.web.model.User;
import com.web.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User findUserById(Long id) throws Exception {
		Optional<User> user = userRepository.findById(id);
		if(user.isPresent()) {
			return user.get();
		}
		throw new Exception("User not found with id "+id);
	}

	@Override
	public User findUserProfileByJwt(String jwt) throws Exception {
		String email = JwtProvider.getEmailFromJwtToken(jwt);
		User user = userRepository.findUserByEmail(email);
		if(user == null) {
			throw new Exception("User not found with email "+email);
		}
		return user;
	}
}
