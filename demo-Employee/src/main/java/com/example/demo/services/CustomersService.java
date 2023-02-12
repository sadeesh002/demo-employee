package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CustomersDao;
import com.example.demo.entities.Customers;

@Service("cs")
public class CustomersService {
	@Autowired
	CustomersDao cd;

	public String addCustomers(Customers customers) {
		Customers c=cd.save(customers);
		return "Added successfully with Id: "+c.getCid();
	}

	public List<Customers> getAll() {
		// TODO Auto-generated method stub
		return cd.findAll();
	}

	public List<Customers> getCustomersByProductName(String pname) {
		// TODO Auto-generated method stub
		return cd.fetchAllCustomers(pname);
	}
}
