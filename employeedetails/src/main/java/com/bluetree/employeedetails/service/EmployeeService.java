package com.bluetree.employeedetails.service;

import java.util.List;
import java.util.Optional;

import com.bluetree.employeedetails.entity.Employees;

public interface EmployeeService {

	public List<Employees> getAllEmployees();
	
	public Employees saveEmployees(Employees employees);
	
	public Employees updateEmployee(Long id);
	
	public Employees updatedEmployee(Employees employee);
	
	public void deleteEmployee(Long id);
}
