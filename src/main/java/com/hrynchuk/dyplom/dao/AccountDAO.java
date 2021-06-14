package com.hrynchuk.dyplom.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hrynchuk.dyplom.entity.Account;
import com.hrynchuk.dyplom.repo.AccountRepository;


@Component
public class AccountDAO {
	@Autowired
	private AccountRepository repo;
	
	public List<Account> getAll() {
		return repo.findAll();
	}
	public Account findByUserName(String userName) {
		return repo.findByUserName(userName);
	}
}
