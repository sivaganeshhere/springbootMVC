package com.nit.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

@Service
public class ImplService implements interfaceService {

	@Override
	public String wishMessage() {
		LocalDateTime idt=LocalDateTime.now();
		int hour=idt.getHour();
		if(hour>9)
			return "Good Morning";
		else if(hour>12)
			return "Good After Noon";
		else if(hour>4)
			return "Good Evening";
		else
			return "Good Night";
	}

}
