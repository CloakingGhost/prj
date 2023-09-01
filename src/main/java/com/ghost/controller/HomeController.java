package com.ghost.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
@Controller
public class HomeController {

	@GetMapping("")
	public String index(Model model) {
		model.addAttribute("data", "Maven Project~");
		return "root.index";
	}

	@GetMapping("login")
	public String login() {
		return "root.login";
	}

	@PostMapping("login")
	public String getIndex() {
		return "root.index";
	}

	@PostMapping("logout")
	public String logout() {
		return "root.index";
	}
}
