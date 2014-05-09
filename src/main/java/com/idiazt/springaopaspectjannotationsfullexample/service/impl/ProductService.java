package com.idiazt.springaopaspectjannotationsfullexample.service.impl;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.idiazt.springaopaspectjannotationsfullexample.aspects.annotations.LogObject;
import com.idiazt.springaopaspectjannotationsfullexample.dao.ProductDAO;
import com.idiazt.springaopaspectjannotationsfullexample.entities.Product;
import com.idiazt.springaopaspectjannotationsfullexample.service.IService;

@Service
public class ProductService implements IService<Product> {

	@Override
	public Product persist(Product product) {
		return ProductDAO.getInstance().persist(product);
	}

	@Override
	public Collection<Product> list() {
		return ProductDAO.getInstance().list();
	}

	@Override
	@LogObject(orden = 2)
	public Product findById(Long id) {
		return ProductDAO.getInstance().findById(id);
	}

	@Override
	public boolean delete(Long id) {
		return ProductDAO.getInstance().delete(id);
	}

}
