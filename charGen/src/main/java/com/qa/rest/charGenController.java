package com.qa.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.service.charGenService;

@RestController
@RequestMapping("/chargen")
public class charGenController {
	
	private charGenService service;

	@Autowired
	public charGenController(charGenService service) {
		this.service = service;
	}
	
	@GetMapping
	public String charGen() {
		return service.charGen();
	}
	
}
