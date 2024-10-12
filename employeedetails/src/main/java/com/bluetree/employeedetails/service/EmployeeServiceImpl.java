package com.bluetree.employeedetails.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluetree.employeedetails.entity.Employees;
import com.bluetree.employeedetails.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	
	@Autowired
	private EmployeeRepository employeerepository;
	
	@Override
	public List<Employees> getAllEmployees(){
		return employeerepository.findAll();
		
	}

	@Override
	public Employees saveEmployees(Employees employees) {
		employees.calculateAge();
		return employeerepository.save(employees);
	}

	@Override
	public Employees updateEmployee(Long id) {
		return employeerepository.findById(id).get();
	}

	@Override
	public Employees updatedEmployee(Employees updatedEmployee) {
		Employees existingEmployee = employeerepository.findById(updatedEmployee.getId()).orElse(null);
		if(existingEmployee!=null) {
			existingEmployee.setId(updatedEmployee.getId());
			existingEmployee.setName(updatedEmployee.getName());
			existingEmployee.setEmail(updatedEmployee.getEmail());
			existingEmployee.setDob(updatedEmployee.getDob());
			existingEmployee.setAge(updatedEmployee.getAge());
			existingEmployee.setSalary(updatedEmployee.getSalary());
			existingEmployee.setStatus(updatedEmployee.isStatus());
			return employeerepository.save(existingEmployee);
		}else {
			return null;
		}
			
	}

	@Override
	public void deleteEmployee(Long id) {
		   employeerepository.deleteById(id);
		}

}
