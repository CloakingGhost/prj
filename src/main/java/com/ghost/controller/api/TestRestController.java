package com.ghost.controller.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/")
@RestController("apiTestController")
public class TestRestController {

	@GetMapping("test")
	public String test() {
		return "Hello 테스터";
	}

}
