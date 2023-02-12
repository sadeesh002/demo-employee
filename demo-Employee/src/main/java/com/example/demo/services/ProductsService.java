package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ProductsDao;
import com.example.demo.entities.Products;

@Service("ps")
public class ProductsService {
	@Autowired
	ProductsDao pd;

	public String addProducts(Products products) {
		Products p =pd.save(products);
		return "Added Successfully with Id:"+p.getPid();
	}

	public List<Products> getAll() {
		// TODO Auto-generated method stub
		return pd.findAll();
	}

}