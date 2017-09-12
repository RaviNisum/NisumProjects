package com.nisum.demo.controller;

import java.awt.PageAttributes.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nisum.demo.model.EmployeeModel;
import com.nisum.demo.repository.EmployeeRepository;

@RestController
@RequestMapping("/employee")
public class EmployeeController 
{
	@Autowired
	EmployeeRepository employeeRepository;
	
	
//create
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public void createEmployee(@RequestBody  EmployeeModel employeeModel)
	{
		System.out.println("enter into create service");
		employeeRepository.save(employeeModel);	
		System.out.println("inserted successfully");
		
	}	
	
	
//update
	@RequestMapping(method=RequestMethod.PUT)
	public void updateEmployee(@RequestBody EmployeeModel employeeModel)
	{
		System.out.println("enter into update service");
		employeeRepository.save(employeeModel);
		System.out.println("update succesfully");
		
	}	
//read
	@RequestMapping(method=RequestMethod.GET,value="/{empId}")
	public EmployeeModel readEmployee(@PathVariable int empId)
	{
		
		EmployeeModel model=employeeRepository.findOneById(empId);
				
		return model;
	}	
//delete
	@RequestMapping(method=RequestMethod.DELETE,value="/{empId}")
	public void delete(@PathVariable String empId)	
	{
		System.out.println("enter into delete service");
		employeeRepository.delete(empId);		
		System.out.println("delete succesfully");
		return ;
	}	
//count
	@RequestMapping(method=RequestMethod.GET,value="/count")
	public Long employeeCount()
	{
		
		return employeeRepository.count();
		
	}

//exists
	@RequestMapping(method=RequestMethod.GET,value="/exists")
	public boolean employeeExists(@PathVariable String empId)
	{
				
		return employeeRepository.exists(empId);
		
	}
	
	
	
	
	
	
	
	
	
	

}
