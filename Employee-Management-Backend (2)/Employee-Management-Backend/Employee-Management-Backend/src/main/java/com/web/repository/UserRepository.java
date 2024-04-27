package com.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

	public User findUserByEmail(String email);
}
