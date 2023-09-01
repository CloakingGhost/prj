package com.ghost.controller.customer;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ghost.entity.dto.BoardDto;
import com.ghost.service.TestService;

@RequestMapping("/customer/notice/")
@Controller
public class NoticeController {
	@Autowired
	private TestService testService;

	@GetMapping("list")
	public String list(Model model) throws SQLException {
		List<BoardDto> list = testService.getList();
		model.addAttribute("list", list);

		return "notice.list";
	}

	@GetMapping("detail")
	public String detail() {
		return "notice.detail";
	}
}
