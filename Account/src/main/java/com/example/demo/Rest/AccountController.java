package com.example.demo.Rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.jms.core.JmsTemplate;

import com.example.demo.Entity.Account;
import com.example.demo.Entity.SentAccount;
import com.example.demo.service.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountController {
	
	private AccountService service;
	
	@Autowired
	private RestTemplate rest;
	
	@Autowired
	private JmsTemplate jmsTemplate; 
	
	@Autowired
	public AccountController( AccountService service) {
		this.service = service;
	}
	
	private void sendToQueue(Account account){
        SentAccount accountToStore =  new SentAccount(account);
        jmsTemplate.convertAndSend("AccountQueue", accountToStore);
    }
	
	@GetMapping("/getAll")
	public List<Account> getAllAccounts(){
		return service.findAll();
	}
	
	@GetMapping(value = "/getOne/{name}")
	public Account getOneAccount(@PathVariable("name") String name){
		return service.findName(name);
	}
	
	@PostMapping(value = "/createAccount")
	public ResponseEntity<Account> createAccount(@RequestBody Account account){
		String num = rest.getForObject("http://localhost:8082/numgen", String.class);
		String lett = rest.getForObject("http://localhost:8081/chargen", String.class);
		
		String accNo = lett + num;
		
		//String prize = rest.getForObject("http://localhost:8083/prize/get", String.class, "b345265");
		
		//rest.getFor
		
		account.setAccNo(accNo);
		account.setPrize("No Prize");
		
		sendToQueue(account);
		
		
		Account retVal = service.createAccount(account);
		return new ResponseEntity<>(retVal, HttpStatus.CREATED);
		
	}
	
	@PutMapping(value = "/updateAccount")
	public String updateAccount(@RequestBody Account account) {
		return service.updateAccount(account);
	}

	@DeleteMapping(value = "/deleteAccount")
	public String deleteAccount(@RequestBody int id) {
		return service.deleteAccount(id);
	}
}
