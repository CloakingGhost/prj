package com.ghost.controller.api;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ghost.entity.dto.BoardDto;
import com.ghost.service.TestService;

@RequestMapping("/api/")
@RestController("apiTestController")
public class TestRestController {
	@Autowired
	private TestService testService;

	@GetMapping("list")
	public BoardDto list() throws SQLException {
		List<BoardDto> list = testService.getList();
		System.out.println(list);
		return list.get(0);
	}

	@GetMapping("test")
	public String test() {
		return "Hello 테스터";
	}

}
