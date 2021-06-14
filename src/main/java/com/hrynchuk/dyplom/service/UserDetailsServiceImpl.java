package com.hrynchuk.dyplom.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hrynchuk.dyplom.dao.AccountDAO;
import com.hrynchuk.dyplom.entity.Account;
 
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
 
    @Autowired
    private AccountDAO accountDAO;
 
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	Account user = accountDAO.findByUserName(username);

    	if(user == null) {
    		throw new UsernameNotFoundException("User not found");
    	}

    	List<SimpleGrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority("user"));

    	return new User(user.getUserName(), user.getEncrytedPassword(), authorities);
    }
 
}