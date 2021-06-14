package com.hrynchuk.dyplom.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrynchuk.dyplom.entity.Account;


public interface AccountRepository extends JpaRepository<Account, Long> {
	Account findByUserName(String userName);
}
