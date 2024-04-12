package com.jin.pojo;

public class OrderDetal {

	private int orderid;
	private int productid;
	private double price;
	private int quantity;
	private String paymethod;
	private String paystatus;
	
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderId) {
		this.orderid = orderId;
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productId) {
		this.productid = productId;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getPaymethod() {
		return paymethod;
	}
	public void setPaymethod(String payMethod) {
		this.paymethod = payMethod;
	}
	public String getPaystatus() {
		return paystatus;
	}
	public void setPaystatus(String payStatus) {
		this.paystatus = payStatus;
	}
	
	
}
