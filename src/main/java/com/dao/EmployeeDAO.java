package com.dao;

import java.util.List;

import com.model.Employee;

public interface EmployeeDAO {
	
	public int saveEmployee(Employee emp);
	public int DeleteEmployee(int id);
	public int updateEmployee(Employee emp);
	public List<Employee> getAllEmployee();
	public Employee getEmployeeById(int id);

}
