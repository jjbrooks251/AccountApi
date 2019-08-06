package com.example.demo.rest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;

import com.example.demo.Entity.Account;
import com.example.demo.Rest.AccountController;
import com.example.demo.service.AccountServiceImpl;
import org.junit.Assert;

//import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountTest {

	@InjectMocks
	private AccountController controller;
	@Mock
	private AccountServiceImpl service;
	
	private static final Account acc1 = new Account(1, "abc123456", "Josh", "brooks", "jjb@qa.com");
	private static final Account acc2 = new Account(2, "def123456", "krystal", "ryan", "diddle@qa.com");
	
	@Test
	public void getAllAccounts() {
		List<Account> Mock_List = new ArrayList<>();
		Mock_List.add(acc1);
		Mock_List.add(acc2);
		Mockito.when(controller.getAllAccounts()).thenReturn(Mock_List);
		Assert.assertEquals(Mock_List, controller.getAllAccounts());
		Mockito.verify(service).findAll();
	}
	
	@Test
	public void getJosh() {
		List<Account> Mock_List = new ArrayList<>();
		Mock_List.add(acc1);
		Mock_List.add(acc2);
		Mockito.when(service.findName("Josh")).thenReturn(acc1);
		Assert.assertEquals(acc1, controller.getOneAccount("Josh"));
		Mockito.verify(service).findName("Josh");
	}
	
	@Test
	public void createAccount() {
		Mockito.when(service.createAccount(acc1)).thenReturn(acc1);
		Assert.assertEquals(acc1, controller.createAccount(acc1).getBody());
		Mockito.verify(service).createAccount(acc1);
	}
	
	@Test
	public void updateAccount() {
		Mockito.when(service.updateAccount(acc1)).thenReturn("Account Updated");
		Assert.assertEquals("Account Updated", controller.updateAccount(acc1));
		Mockito.verify(service).updateAccount(acc1);
	}
	
	@Test
	public void deleteAccount() {
		Mockito.when(service.deleteAccount(1)).thenReturn("Account Deleted");
		Assert.assertEquals("Account Deleted", controller.deleteAccount(1));
		Mockito.verify(service).deleteAccount(1);
	}
	
}
