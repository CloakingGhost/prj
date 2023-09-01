package com.ghost.service.jpa;

import java.sql.SQLException;
import java.util.List;

import com.ghost.entity.dto.BoardDto;
import com.ghost.service.TestService;

public class JPATestService implements TestService {

	@Override
	public List<BoardDto> getList() throws SQLException {
		return null;
	}

}
