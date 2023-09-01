package com.ghost.service;

import java.sql.SQLException;
import java.util.List;

import com.ghost.entity.dto.BoardDto;

public interface TestService {
	List<BoardDto> getList() throws SQLException;
}
