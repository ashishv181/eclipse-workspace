package com.luv2code.springboot.demo.myCoolApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springboot.demo.myCoolApp.dao.EmployeeDao;
import com.luv2code.springboot.demo.myCoolApp.entity.EmployeeEntity;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDao empDao;

	@Autowired
	public EmployeeServiceImpl(@Qualifier("employeeDaoJPAImpl") EmployeeDao empDao) {
		this.empDao = empDao;
	}

	@Override
	@Transactional
	public List<EmployeeEntity> findAll() {
		return empDao.findAll();
	}

	@Override
	@Transactional
	public EmployeeEntity findById(int theId) {
		return empDao.findById(theId);
	}

	@Override
	@Transactional
	public List<EmployeeEntity> saveEmployee(EmployeeEntity theEmployee) {
		empDao.saveEmployee(theEmployee);
		return findAll();
	}

	@Override
	@Transactional
	public List<EmployeeEntity> deleteById(int theId) {
		empDao.deleteById(theId);
		return findAll();
	}

}
