package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private CustomerRepository repository;


	@Override
	public void run(String... args) throws Exception { // need clarity on this syntax

		repository.deleteAll();

		// save a couple of customers
		repository.save(new Customer("ravi", "kumar"));
		repository.save(new Customer("sai", "kumar"));

		// fetch all customers
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (Customer customer : repository.findAll()) 
		{
			System.out.println(customer);
		}
		
		System.out.println();

		// fetch an individual customer
		System.out.println("Customer found with findByFirstName:");
		System.out.println("--------------------------------");
		System.out.println(repository.findByFirstName("ravi"));

		System.out.println("Customers found with findByLastName");
		System.out.println("--------------------------------");
		for (Customer customer : repository.findByLastName("kumar")) 
		{
		 System.out.println(customer);
		 //System.out.println("----"+repository.findByLastName//
		
		
		}
	}
}

