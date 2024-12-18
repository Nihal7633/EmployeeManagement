package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepo;
	public Employee registerEmployee(Employee employee) {
		Employee employee1 = employeeRepo.save(employee);
		return employee;
		
	}
	public List<Employee> getAllEmployee(){
		List<Employee> allEmployees = employeeRepo.findAll();
		return allEmployees;
		
	}
	
	public Employee getByEmployeeId(long id) {
		Employee employee = employeeRepo.getById(id);
		return employee;
	}
	
	public String deleteEmployeeById(long id) {
		try {
		employeeReo.deleteById(id);
		return "Employee is deleted sucessfully";
		}
		catch(Exception e) {
			
		return "Employee is not deleted Sucessfully";
		}
	}
     public Employee updateEmployeeById(Employee employee) {
    	 Employee employee1=employeeReo.getById(employee.getId());
    	 employee1.setFirstName(employee.getFirstName());
    	 employee1.setEmailId(employee.getEmailId());
    	 employee1.setLastName(employee.getLastName());
    	 Employee employee2=employeeReo.save(employee1);
    	 return employee2;
     }
   }