package com.example.epoint.model;
public class Products {

	private int id;
	
	private String name;
	
	private double price;

	
	
	
	public int getId() {
		return id;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public double getPrice() {
		return price;
	}




	public void setPrice(double price) {
		this.price = price;
	}




	public Products(int id, String name, double price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}




	public Products() {
	}




	public void setId(int id) {
		this.id = id;
	}
	
	
}
