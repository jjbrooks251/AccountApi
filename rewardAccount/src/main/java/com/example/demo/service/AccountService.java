package com.example.demo.service;

import java.util.List;

import com.example.demo.Entity.Account;

public interface AccountService {

	public List<Account> findAll();
	
	public Account createAccount(Account account);
	
	public Account findName(String name);
	
	public String deleteAccount(int id);
	
	public String updateAccount(Account account);
	
	public String myUpdate(Account account);
	 
}
