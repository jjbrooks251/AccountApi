package com.qa.service;

import org.springframework.stereotype.Service;

@Service
public class prizeServiceImpl implements prizeService {

	@Override
	public String prizes(String accNo) {
		
		if (accNo.length() == 25) {
			
			if (!accNo.contains("a") ) {
				return "Win Nothing";
			} else if (accNo.contains("b")) {
				return "Win $50";
			} else {
				return "Win $100";
			}
			
//		} else if (accNo.length() == 27) {
//			
//			if (!accNo.contains("a") ) {
//				return "Win Nothing";
//			} else if (accNo.contains("b")) {
//				return "Win $500";
//			} else {
//				return "Win $750";
//			}
//			
//		} else if (accNo.length() == 29) {
//			
//			if (!accNo.contains("a") ) {
//				return "Win Nothing";
//			} else if (accNo.contains("b")) {
//				return "Win $5000";
//			} else {
//				return "Win $10000";
//			}
			
		} else {
			return "Invalid Account Number length: " + accNo.length();
		}
	}
	
}
