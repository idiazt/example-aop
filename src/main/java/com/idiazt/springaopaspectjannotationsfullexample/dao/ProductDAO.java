package com.idiazt.springaopaspectjannotationsfullexample.dao;

import java.util.ArrayList;
import java.util.List;

import com.idiazt.springaopaspectjannotationsfullexample.entities.Product;

public class ProductDAO extends BaseDAO<Product> {
	
	private static ProductDAO instance;
	
	public static ProductDAO getInstance() {
		if (instance == null)
			instance = new ProductDAO();
		return instance;
	}

	@Override
	public Product persist(Product entity) {
		//TODO this is just for exaple code
		return entity;
	}

	@Override
	public List<Product> list() {
		//TODO this is just for exaple code
		List<Product> result = new ArrayList<Product>();
		result.add(new Product(1L, "1-Orange", "a fresh citrus fruit"));
		result.add(new Product(2L, "2-Strawberry", "a fresh red fruit"));
		return result;
	}

	@Override
	public Product findById(Long id) {
		//TODO this is just for exaple code
		return new Product(id, "2-Strawberry", "a fresh red fruit");
	}

	@Override
	public boolean delete(Long id) {
		//TODO this is just for exaple code
		return true;
	}

}
