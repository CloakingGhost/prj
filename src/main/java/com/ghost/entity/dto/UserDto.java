package com.ghost.entity.dto;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDto implements UserDetails {
	private int id;
	private String username;
	private String password;
	private Date entryDate;
	private Date modifyDate;
	private List<GrantedAuthority> authorities;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	@Override
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	// 권한
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(String authority) {
		LoggerFactory.getLogger(UserDto.class.getSimpleName()).info(authority);
		if (authorities == null)
			authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(authority));
	}

	public void setAuthorities(List<GrantedAuthority> authorities) {
		LoggerFactory.getLogger(UserDto.class.getSimpleName()).info(authorities.toString());
		this.authorities = authorities;
	}

	@Override
	// 계정이 만료 되지 않았는가?
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	// 계정이 잠기지 않았는가?
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	// 패스워드가 만료되지 않았는가?
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	// 계정이 활성화 되었는가?
	public boolean isEnabled() {
		return true;
	}

	@Override
	public String toString() {
		return "UserDto [id=" + id + ", username=" + username + ", password=" + password + ", entryDate=" + entryDate
				+ ", modifyDate=" + modifyDate + ", authorities=" + authorities + "]";
	}

}
