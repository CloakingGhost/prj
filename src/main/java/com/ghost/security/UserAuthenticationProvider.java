package com.ghost.security;

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
	private final UserService USER_SERVICE;
	private final BCryptPasswordEncoder PASSWORD_ENCODER;

	@Autowired
	public UserAuthenticationProvider(UserService userService, BCryptPasswordEncoder passwordEncoder) {
		this.USER_SERVICE = userService;
		this.PASSWORD_ENCODER = passwordEncoder;
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getPrincipal().toString();
		String password = authentication.getCredentials().toString();

		UserDto user = (UserDto) USER_SERVICE.loadUserByUsername(username);

		if (user != null && PASSWORD_ENCODER.matches(password, user.getPassword())) {
			return new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
		}

		return null;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return true;
	}

}
