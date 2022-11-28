package com.luv2code.springboot.demo.myCoolApp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Employees_test")
public class EmployeeEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="EMPLOYEE_NUMBER")
	private int employeeNumber;
	@Column(name="EMPLOYEE_NAME")
	private String employeeName;
	@Column(name="SALARY")
	private int salary;
	
	public EmployeeEntity() {
		// no-arg constructor is required by Hibernate
	}

	public EmployeeEntity(String employeeName, int salary) {
		this.employeeName = employeeName;
		this.salary = salary;
	}

	public int getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(int employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public String employeeName() {
		return employeeName;
	}

	public void setEmployeeNmae(String employeeName) {
		this.employeeName = employeeName;
		
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "EmployeeEntity [employeeNumber=" + employeeNumber + ", employeeNmae=" + employeeName + ", salary="
				+ salary + "]";
	}
	
}
