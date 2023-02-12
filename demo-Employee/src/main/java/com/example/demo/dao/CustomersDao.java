package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Customers;

@Repository("cd")
public interface CustomersDao extends JpaRepository<Customers, Integer>{
	@Query("select obj from Customers obj join obj.products obj1 where obj1.pname=:pn")
	List<Customers> fetchAllCustomers(@Param("pn") String pname);
	}
