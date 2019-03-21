package com.fpt.prm.mapper;

import com.fpt.prm.model.Account;

public interface AccountMapper {
	public Account findByUsername(String username);
}
