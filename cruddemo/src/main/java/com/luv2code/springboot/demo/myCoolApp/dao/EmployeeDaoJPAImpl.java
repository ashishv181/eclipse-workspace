package com.luv2code.springboot.demo.myCoolApp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.demo.myCoolApp.entity.EmployeeEntity;

@Repository
public class EmployeeDaoJPAImpl implements EmployeeDao {
	
	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDaoJPAImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<EmployeeEntity> findAll() {
		TypedQuery<EmployeeEntity> theQuery = entityManager.createQuery("from EmployeeEntity", EmployeeEntity.class);
		return theQuery.getResultList();
	}

	@Override
	public EmployeeEntity findById(int theId) {
		EmployeeEntity empEntity = entityManager.find(EmployeeEntity.class, theId);
		return empEntity;
	}

	@Override
	public void saveEmployee(EmployeeEntity theEmployee) {
		entityManager.merge(theEmployee);
	}

	@Override
	public void deleteById(int theId) {
		EmployeeEntity emp = findById(theId);
		entityManager.remove(emp);
	}

}
