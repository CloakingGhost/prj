package com.ghost.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.ghost.entity.dto.UserDto;

public interface UserService extends UserDetailsService {

	int signup(UserDto user);
}
