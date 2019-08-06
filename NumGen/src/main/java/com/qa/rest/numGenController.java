package com.qa.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.service.numGenerator;

@RestController
@RequestMapping("/numgen")
public class numGenController {
	
	private numGenerator service;
	
	@Autowired
	public numGenController(numGenerator service) {
		this.service = service;
	}
	
	@GetMapping
	public String numgen() {
		return service.ranNum();
	}

}
