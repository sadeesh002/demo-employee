package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Customers;
import com.example.demo.services.CustomersService;

@RestController
public class CoustomersController {
	@Autowired
	CustomersService cs;
	
	@PostMapping("/customers")
	public String addCustomers(@RequestBody Customers customers)
	{
		return cs.addCustomers(customers);
	}
	@GetMapping("/customers")
	public List<Customers> getAll()
	{
		return cs.getAll();
	}
	@GetMapping("/customers/products/byName/{pname}")
	List<Customers> getAllCustomerByProductName(@PathVariable("pname") String pname)
	{
		return cs.getCustomersByProductName(pname);
	}
}
