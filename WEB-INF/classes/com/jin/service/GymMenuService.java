package com.jin.service;

import java.util.List;

import com.jin.pojo.Order;
import com.jin.pojo.OrderDetal;
import com.jin.pojo.Product;

public interface GymMenuService {
	
	public List<Product> getProducts();
	
	public String[] getCartList(String list);
	
	public Integer pay(Order order,String method,String[] productId);
	
	public List<OrderDetal> getOrder(int orderid);

}
