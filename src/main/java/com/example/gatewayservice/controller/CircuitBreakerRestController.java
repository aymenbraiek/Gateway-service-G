package com.example.gatewayservice.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CircuitBreakerRestController {
	
	@GetMapping("/defaultCountries")
    public Map<String,String> countries()
    {
        Map<String,String> data=new HashMap<>();
        data.put("message"," default countries");
        data.put("countries","algerie, tunisie, maroc");
        return data;

    }
	 @GetMapping("/defaultdate")
	    public Map<String,String> muslims()
	    {
	        Map<String,String> date=new HashMap<>();
	        date.put("message"," default horaire de priére");
	        date.put("fajr","04:55");
	        date.put("dohr","12:36");
	        date.put("moghreb","19:45");
	        return date;

	    }
}
