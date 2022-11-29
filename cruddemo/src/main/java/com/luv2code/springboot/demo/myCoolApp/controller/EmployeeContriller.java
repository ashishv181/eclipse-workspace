package com.luv2code.springboot.demo.myCoolApp.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping("/employees/{empId}")
	public EmployeeEntity getSingleEmployee(@PathVariable int empId) {
		EmployeeEntity emp = empService.findById(empId);
		System.out.println(emp);
		return emp;
	}
	
	@PostMapping("/addEmployee")
	public List<EmployeeEntity> addEmployee(@RequestBody EmployeeEntity empReqEnt){
		empReqEnt.setEmployeeNumber(0);
		return empService.saveEmployee(empReqEnt);
	}
	
	@DeleteMapping("/deleteEmployee/{empId}")
	public List<EmployeeEntity> deleteEmployee(@PathVariable int empId){
		return empService.deleteById(empId);
	}
	
	@PutMapping("/updateEmployee")
	public List<EmployeeEntity> updateEmployee(@RequestBody EmployeeEntity empReqEnt){
		System.out.println(empReqEnt);
		return empService.saveEmployee(empReqEnt);
	}
}
