package com.web.service;

import com.web.model.User;

public interface UserService {

	public User findUserById(Long id) throws Exception;
	
	public User findUserProfileByJwt(String jwt) throws Exception;
}
