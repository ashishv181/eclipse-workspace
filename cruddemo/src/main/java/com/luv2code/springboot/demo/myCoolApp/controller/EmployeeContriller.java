package com.luv2code.springboot.demo.myCoolApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springboot.demo.myCoolApp.dao.EmployeeDao;
import com.luv2code.springboot.demo.myCoolApp.entity.EmployeeEntity;
import com.luv2code.springboot.demo.myCoolApp.service.EmployeeService;

@RestController
@RequestMapping("/")
public class EmployeeContriller {
	
	@Autowired
	private EmployeeService empService;
	
	@GetMapping("/api")
	public String welcome() {
		return "Welcome to the Employee Portal";
	}
	@GetMapping("/employees")
	public List<EmployeeEntity> getAllEmployees() {
		List<EmployeeEntity> empList =  empService.findAll();
		System.out.println(empList);
		return empList;
	}
	
}
