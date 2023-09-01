package com.ghost.service.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ghost.entity.dto.UserDto;

@Repository("userDao")
public class UserDao {
	private final DataSource dataSource;

	@Autowired
	public UserDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public UserDto getUserByUsername(String username) {
		String sql = "select * from user where username = ?";

		UserDto dto = null;
		try {
			Connection con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println("rs : " + rs);
				dto = new UserDto();
				dto.setId(rs.getInt("id"));
				dto.setUsername(rs.getString("username"));
				dto.setPassword(rs.getString("password"));
				dto.setRole(rs.getString("role"));
				dto.setEntryDate(rs.getDate("entry_date"));
				dto.setModifyDate(rs.getDate("modify_date"));
				dto.setAuthorities(rs.getString("username"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dto;
	}
}
