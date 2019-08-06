package com.qa.service;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class numGeneratorImpl implements numGenerator{

	@Override
	public String ranNum() {
		Random rnd = new Random();
	    int number = rnd.nextInt(999999);

	    return String.format("%06d", number);
	}

}
