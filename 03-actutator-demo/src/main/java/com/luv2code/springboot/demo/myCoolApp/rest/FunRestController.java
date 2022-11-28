package com.luv2code.springboot.demo.myCoolApp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
	
	@GetMapping("/")
	public String sayHello() {
		return "Hello SpringBoot, This is my Spring Boot Cool Application!! And this change is visible without restarting the app because of dev tools";
	}
}
