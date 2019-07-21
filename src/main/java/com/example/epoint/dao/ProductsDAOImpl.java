package com.example.epoint.dao;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.epoint.model.Products;

@Repository
public class ProductsDAOImpl implements ProductsDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	 
	

	@Override
	public void saveOrUpdate(Products product) {
		 if (product.getId() > 0) {
		        // update
		        String sql = "UPDATE products SET name=?, price=?  WHERE id=?";
		        jdbcTemplate.update(sql, product.getName(), product.getPrice(), product.getId());
		    } else {
		        // insert
		        String sql = "INSERT INTO products (name, price)"
		                    + " VALUES (?, ?)";
		        jdbcTemplate.update(sql, product.getName(), product.getPrice());
		    }
		
	}

	@Override
	public void delete(int productId) {
		String sql = "delete from products where id = ?";
		jdbcTemplate.update(sql, productId);
	}

	@Override
	public Products get(int productId) {
		String sql = "select * from products where id = ?";
		RowMapper<Products> rowMapper = (rs, rowNum) -> new Products(rs.getInt("id"),rs.getString("name"), rs.getDouble("price"));
		Products product = (Products)jdbcTemplate.queryForObject(
				sql, rowMapper,productId);
			
		return product;
	}

	@Override
	public List<Products> list() {
				//List<Map<String, Object>> queryForList = jdbcTemplate.queryForList("select * from products");
		List<Products> products = jdbcTemplate.query
				("select * from products", (rs, rowNum) -> new Products(rs.getInt("id"),rs.getString("name"), rs.getDouble("price")));
		return products;
	}
	
}
