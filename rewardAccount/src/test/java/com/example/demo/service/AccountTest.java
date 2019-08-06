package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.Entity.Account;
import com.example.demo.repository.AccountRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountTest {
	
	@InjectMocks
	private AccountServiceImpl service;
	@Mock
	private AccountRepository repo;
	
	private static final Account acc1 = new Account(1, "abc123456", "Josh", "brooks", "jjb@qa.com");
	private static final Account acc2 = new Account(2, "def123456", "krystal", "ryan", "diddle@qa.com");
	
	@Ignore
	public void loadTest() {
		//Assert.assertThat(controller).isNotNull();
	}
	
	@Test
	public void getAllAccounts() {
		List<Account> Mock_List = new ArrayList<>();
		Mock_List.add(acc1);
		Mock_List.add(acc2);
		Mockito.when(repo.findAll()).thenReturn(Mock_List);
		Assert.assertEquals(Mock_List, service.findAll());
		Mockito.verify(repo).findAll();
	}
	
	@Test
	public void getJosh() {
		List<Account> Mock_List = new ArrayList<>();
		Mock_List.add(acc1);
		Mock_List.add(acc2);
		Mockito.when(repo.findByfirstName("Josh")).thenReturn(acc1);
		Assert.assertEquals(acc1, service.findName("Josh"));
		Mockito.verify(repo).findByfirstName("Josh");
	}
	
	@Test
	public void createAccount() {
		Mockito.when(repo.save(acc1)).thenReturn(acc1);
		Assert.assertEquals(acc1, service.createAccount(acc1));
		Mockito.verify(repo).save(acc1);
	}
	
	@Test
	public void updateAccount() {
		Mockito.when(repo.save(acc2)).thenReturn(acc2);
		Assert.assertEquals("Account updated", service.updateAccount(acc2));
		//Mockito.verify(repo).deleteById(1);
		Mockito.verify(repo).save(acc2);
	}
	
	@Test
	public void deleteAccounr() {
		Assert.assertEquals("Account Deleted", service.deleteAccount(1));
	}
}
