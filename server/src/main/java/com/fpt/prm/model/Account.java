package com.fpt.prm.model;

import java.sql.Date;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Account implements UserDetails {
	private String userName;
	private String password;
	private String fullName;
	private String address;
	private String phoneNumber;
	private String email;
	private String avatar;
	private String money;
	private String role;
	private String createUser;
	private Date createdDate;
	private String updatedUser;
	private Date updatedDate;
	
	public Account(String userName, String password, String fullName, String address, String phoneNumber, String email,
			String avatar, String money, String role, String createUser, Date createdDate, String updatedUser,
			Date updatedDate) {
		super();
		this.userName = userName;
		this.password = password;
		this.fullName = fullName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.avatar = avatar;
		this.money = money;
		this.role = role;
		this.createUser = createUser;
		this.createdDate = createdDate;
		this.updatedUser = updatedUser;
		this.updatedDate = updatedDate;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsername() {
		
		return this.userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
}
