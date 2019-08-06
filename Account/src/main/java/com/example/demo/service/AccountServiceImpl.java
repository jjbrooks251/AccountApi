package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Account;
import com.example.demo.repository.AccountRepository;

@Service
public class AccountServiceImpl implements  AccountService{

	private AccountRepository accountRepo;
	
	@Autowired
	public AccountServiceImpl(AccountRepository accountRepo) {
		this.accountRepo = accountRepo;
	}
	
	@Override
	public List<Account> findAll() {
		
		return accountRepo.findAll();
	}

	@Override
	public Account createAccount(Account account) {
		
		return accountRepo.save(account);
	}

	@Override
	public Account findName(String name) {
		
		return accountRepo.findByfirstName(name); 
	}

	@Override
	public String deleteAccount(int id) {
			accountRepo.deleteById(id);
		return "Account Deleted";
	}

	@Override
	public String updateAccount(Account account) {
			accountRepo.deleteById(account.getaId());
			accountRepo.save(account);
		return "Account Updated";
	}

	@Override
	public String myUpdate(Account account) {
			
		return "Account updated";
	} 

}
