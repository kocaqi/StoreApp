package com.localweb.thelogin.thelogin.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import com.localweb.thelogin.thelogin.dao.UserRepository;
import com.localweb.thelogin.thelogin.entities.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserService{
	
	@Autowired
	private final UserRepository userRepository;
	
	@Autowired
	public UserService(UserRepository repository) {
		this.userRepository=repository;
	}

	@Transactional
	public User findUserByEmail(String email){
		return userRepository.findUserByEmail(email);
	}

	public User loadUserByUsername(String email){
		User user = userRepository.findUserByEmail(email);
		if(user==null){
			throw new UsernameNotFoundException("Not found!");
		}
		return user;
	}

}

