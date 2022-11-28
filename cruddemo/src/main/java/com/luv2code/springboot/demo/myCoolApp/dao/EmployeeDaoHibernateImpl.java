package com.luv2code.springboot.demo.myCoolApp.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springboot.demo.myCoolApp.entity.EmployeeEntity;

@Repository
public class EmployeeDaoHibernateImpl implements EmployeeDao {

	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDaoHibernateImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public List<EmployeeEntity> findAll() {
		//get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		//create a query
		Query<EmployeeEntity> theQuery = currentSession.createQuery("from EmployeeEntity", EmployeeEntity.class);
				
		//execute query and get result list
		List<EmployeeEntity> empList = theQuery.getResultList();
		
		// return the results
		return empList;
	}

	@Override
	public EmployeeEntity findById(int theId) {
		// get the current session
		Session currentSession = entityManager.unwrap(Session.class);
		
		//get the employee
		EmployeeEntity emp = currentSession.get(EmployeeEntity.class, theId);
		
		//execute the query
		
		return emp;
	}

	@Override
	public void saveEmployee(EmployeeEntity theEmployee) {
		// get the session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// if primary key = 0 then saves else updates
		currentSession.saveOrUpdate(theEmployee);
		
	}

	@Override
	public void deleteById(int theId) {
		// get the session
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query theQuery = currentSession.createQuery("delete from EmployeeEntity where id=:employeeId");
		theQuery.setParameter("employeeId", theId);
		
		theQuery.executeUpdate();
		
	}

}
