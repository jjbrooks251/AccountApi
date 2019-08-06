package com.qa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class charGenServiceImpl implements charGenService {

	@Override
	public String charGen() {
		List<String> chars = new ArrayList<>();
		
		chars.add("a");
		chars.add("b");
		chars.add("c");
		
		Random rnd = new Random();
		int number = rnd.nextInt(3);
		
		return chars.get(number);
	}

}
