package com.jin.pojo;

public class Product {
	
	private int productId;
	private String productName;
	private String descript;
	private double price;
	private String category;
	private String image;
	
	public Product() {
		
	}
	
	public Product(int id,String name,String descript,double price,String category,String image) {
		this.productId=id;
		this.productName=name;
		this.descript=descript;
		this.price=price;
		this.category=category;
		this.image=image;
	}
	
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getDescript() {
		return descript;
	}
	public void setDescript(String descript) {
		this.descript = descript;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	

}
