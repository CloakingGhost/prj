package com.ghost.controller.user;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ghost.entity.dto.UserDto;
import com.ghost.service.UserService;

@RequestMapping("/")
@Controller
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class.getSimpleName());
	private final UserService userService;
	private final PasswordEncoder encoder;

	@GetMapping("login")
	public String login() {
		return "root.login";
	}

	@Autowired
	public UserController(PasswordEncoder encoder, UserService userService) {
		this.encoder = encoder;
		this.userService = userService;
	}

	@PostMapping("login")
	public String getIndex() {
		return "root.index";
	}

	@PostMapping("logout")
	public String logout() {
		return "root.index";
	}

	@RequestMapping("signup")
	public String signUp(HttpServletRequest request, String username, String password) {

		String method = request.getMethod();
		if (method.equals("GET")) {
			return "root.signup";
		} else if (method.equals("POST")) {
			UserDto user = (UserDto) userService.loadUserByUsername(username);
			if (user != null) {
				request.setAttribute("result", "이미 존재하는 ID 입니다.");
				return "root.signup";
			} else {
				user = new UserDto();
				String encodingPW = encoder.encode(password);
				user.setUsername(username);
				user.setPassword(encodingPW);
				int result = userService.signup(user);
				logger.info("result : {}", result);
			}
			return "root.signup";
		} else {
			return "root.index";
		}
	}
}
