package com.example.epoint.dao;

import java.util.List;

import com.example.epoint.model.Products;

public interface ProductsDAO {
	public void saveOrUpdate(Products product);
    
    public void delete(int productId);
     
    public Products get(int productId);
     
    public List<Products> list();
}
