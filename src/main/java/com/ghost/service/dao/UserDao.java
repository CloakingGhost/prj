package com.ghost.service.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.ghost.entity.dto.UserDto;

@Repository
public class UserDao {
	private static final Logger logger = LoggerFactory.getLogger(UserDao.class.getSimpleName());
	private final DataSource dataSource;

	@Autowired
	public UserDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public UserDetails getUserByUsername(String username) {
		String sql = "select * from user where username = ?";

		UserDto dto = null;
		try {
			Connection con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				dto = new UserDto();
				dto.setId(rs.getInt("id"));
				dto.setUsername(rs.getString("username"));
				dto.setPassword(rs.getString("password"));
				dto.setEntryDate(rs.getDate("entry_date"));
				dto.setModifyDate(rs.getDate("modify_date"));
				dto.setAuthorities(getAuthorities(username, con));
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info(dto != null ? dto.toString() : "user ref is null");
		return dto;
	}

	private List<GrantedAuthority> getAuthorities(String username, Connection con) {
		String sql = "select authority from authority where username = ?";
		List<GrantedAuthority> authorities = new ArrayList<>();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String authority = rs.getString("authority");
				authorities.add(new SimpleGrantedAuthority(authority));
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return authorities;

	}

	public int insertUser(UserDto user) {
		String sql = "insert into user(username, password) values(?, ?)";
		try {
			Connection con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			int result = ps.executeUpdate();
			ps.close();
			con.close();

			return result;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}
