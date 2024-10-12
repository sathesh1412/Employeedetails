package com.bluetree.employeedetails.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;

import com.bluetree.employeedetails.entity.Employees;
import com.bluetree.employeedetails.service.EmployeeService;

@Controller
public class EmployeesController {
	
	@Autowired
	private EmployeeService employeeservice;
	
	@GetMapping("/")
	public String home() {
		return "redirect:/getAllEmployees";
	}
	
	@PostMapping("/savedEmployees")
	public String saveEmployees(Employees employees) {
		employeeservice.saveEmployees(employees);
		return "redirect:/getAllEmployees";
	}
	
	@GetMapping("/getAllEmployees")
	public String getAllEmployees(Model model) {
		List<Employees>employee = employeeservice.getAllEmployees();
		model.addAttribute("AllEmployees",employee);
		return "Home";
	}
	
	@GetMapping("/addNewEmployee")
	public String addNewEmployee() {
		return "addNewEmployee";
	}
	
	@GetMapping("/updateEmployee/{id}")
	public String updateEmployee(@PathVariable Long id,Model model) {
		Employees employee = employeeservice.updateEmployee(id);
		if(employee!=null) {
			model.addAttribute("employee",employee);
			return "updateEmployeeForm";
		}else {
			return "errorPage";
		}
	}
	
	@PostMapping("/updatedEmployee/{id}")
	public String updatedEmployee(Employees employee,@PathVariable Long id) {
		employee.setId(id);
		employeeservice.updatedEmployee(employee);
		return "redirect:/getAllEmployees";
		
	}
	
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable Long id) {
		employeeservice.deleteEmployee(id);
		return "redirect:/getAllEmployees";
	}
	
	
	

}
