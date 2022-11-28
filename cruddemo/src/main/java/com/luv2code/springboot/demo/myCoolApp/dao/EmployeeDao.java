package com.luv2code.springboot.demo.myCoolApp.dao;

import java.util.List;

import com.luv2code.springboot.demo.myCoolApp.entity.EmployeeEntity;

public interface EmployeeDao {
	
	public List<EmployeeEntity> findAll();
	
	public EmployeeEntity findById(int theId);
	
	public void saveEmployee(EmployeeEntity theEmployee);
	
	public void deleteById(int theId);
}
