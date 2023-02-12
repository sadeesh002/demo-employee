package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Products;
import com.example.demo.services.ProductsService;

@RestController
public class ProductsController {
	@Autowired
	ProductsService ps;
	
	@PostMapping("/products")
	public String addProducts(@RequestBody Products products)
	{
		return ps.addProducts(products);
	}
	@GetMapping("/products")
	public List<Products> getAllProducts()
	{
		return ps.getAll();
	}
}
