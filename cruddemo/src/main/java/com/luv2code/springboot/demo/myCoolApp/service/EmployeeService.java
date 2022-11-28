package com.luv2code.springboot.demo.myCoolApp.service;

import java.util.List;

import com.luv2code.springboot.demo.myCoolApp.entity.EmployeeEntity;

public interface EmployeeService {

	public List<EmployeeEntity> findAll();

	public EmployeeEntity findById(int theId);

	public void saveEmployee(EmployeeEntity theEmployee);

	public void deleteById(int theId);
}
