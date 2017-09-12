
package com.nisum.demo.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.nisum.demo.model.EmployeeModel;
import com.nisum.demo.repository.EmployeeRepository;

@RunWith(SpringJUnit4ClassRunner.class)

public class EmployeeControllerTest {

@InjectMocks
EmployeeController employeeController;

@Mock
EmployeeRepository empRepository;
	
@Test
public void getEmployeeNameTest()
{
		
	EmployeeModel model=new EmployeeModel();
	model.setFirstName("ravi");
	model.setLastName("kumar");
	
	when(empRepository.findOneById(16728)).thenReturn(model);
	EmployeeModel actualVal=employeeController.readEmployee(16728);	
	
	assertEquals("ravi",actualVal.getFirstName());
	assertEquals("kumar", actualVal.getLastName());   
        return ;
    }
	
@Test
public void getEmployeeAgeTest()
{
		
	EmployeeModel model=new EmployeeModel();
	model.setAge(25);
	
	when(empRepository.findOneById(16728)).thenReturn(model);
	EmployeeModel actualVal=employeeController.readEmployee(16728);	
	assertEquals(25,actualVal.getAge());
	 
        return ;
    }

@Test
public void getEmployeeCountTest() 
{

long  expectedValue=2;

when(empRepository.count()).thenReturn(2l);

long actualValue =employeeController.employeeCount();

assertEquals(expectedValue, actualValue); 

}

@Test
public void  getEmployeeExistsTest() 
{

boolean expectedValue=true;
when(empRepository.exists("16278")).thenReturn(true);

boolean actualValue =employeeController.employeeExists("16278");

assertEquals(expectedValue, actualValue); 

}






















}