package com.nisum.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.nisum.demo.model.EmployeeModel;

public interface EmployeeRepository extends MongoRepository<EmployeeModel, String> 
{

	public  EmployeeModel findOneByFirstName(String empName);
	public  EmployeeModel findOneById(int empId);
	//public int  delete(int empId);//
	
	
	
	
}
