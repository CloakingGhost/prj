package com.ghost.service.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ghost.entity.dto.BoardDto;
import com.ghost.service.TestService;

@Repository
public class JDBCTestService implements TestService {
	@Autowired
	private final DataSource dataSource;

	public JDBCTestService(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public List<BoardDto> getList() throws SQLException {

		System.out.println("Test Service");
		String sql = "SELECT * FROM BOARD limit 10";
		Connection con = dataSource.getConnection();
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		List<BoardDto> list = new ArrayList<>();
		while (rs.next()) {
			BoardDto dto = new BoardDto();
			dto.setId(rs.getInt(1));
			dto.setTitle(rs.getString(2));
			dto.setTitle(rs.getString(3));
			dto.setId(rs.getInt(4));
			dto.setEntryDate(rs.getDate(5));
			dto.setModifyDate(rs.getDate(6));
			list.add(dto);
		}
		rs.close();
		st.close();
		con.close();
		return list;
	}

}
