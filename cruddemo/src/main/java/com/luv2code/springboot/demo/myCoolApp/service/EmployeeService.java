package com.luv2code.springboot.demo.myCoolApp.service;

import java.util.List;

import com.luv2code.springboot.demo.myCoolApp.entity.EmployeeEntity;

public interface EmployeeService {

	public List<EmployeeEntity> findAll();

	public EmployeeEntity findById(int theId);

	public List<EmployeeEntity> saveEmployee(EmployeeEntity theEmployee);

	public List<EmployeeEntity> deleteById(int theId);
}
