package com.fpt.prm.mapper;

import java.util.List;

import com.fpt.prm.model.Account;

public interface AccountMapper {
	
	public Account findByUsername(String username);
	
	public int regUser(Account acc);
	
	public List<Account> findAllUsers();
}
