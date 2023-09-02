package com.ghost.security;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ghost.entity.dto.UserDto;
import com.ghost.service.UserService;

@Service
public class UserAuthenticationProvider implements AuthenticationProvider {
	private final UserService userService;
	private final BCryptPasswordEncoder encoder;

	@Autowired
	public UserAuthenticationProvider(UserService userService, BCryptPasswordEncoder encoder) {
		this.userService = userService;
		this.encoder = encoder;
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getPrincipal().toString();
		String password = authentication.getCredentials().toString();

		UserDto user = (UserDto) userService.loadUserByUsername(username);
		LoggerFactory.getLogger(UserAuthenticationProvider.class.getSimpleName()).info(user.toString());
		if (user != null && encoder.matches(password, user.getPassword())) {
			return new UsernamePasswordAuthenticationToken(user, user.getPassword(), user.getAuthorities());
		}

		return null;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return true;
	}

}
