package com.jin.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jin.dao.GymMenuDao;
import com.jin.pojo.Order;
import com.jin.pojo.OrderDetal;
import com.jin.pojo.Product;

@Service
public class GymMenuServiceImpl implements GymMenuService {

	@Autowired
	GymMenuDao dao;
	
	@Override
	public List<Product> getProducts() {
		
		List<Product> list=dao.getProducts();
		if(list!=null) {
			return list;
		}
		return null;
	}
	
	@Override
	public String[] getCartList(String list) {
		
		String[]result=list.split(",");
		
		return result;
	}
	
	@Override
	public Integer pay(Order order,String method,String[] produictId) {
		String formattedDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		order.setOrderdate(formattedDate);
		Integer orderid=dao.pay(order, method, produictId);
		
		if(orderid!=null) {
			return orderid;
		}else {
			return null;
		}
	}
	
	@Override
	public List<OrderDetal> getOrder(int orderid) {
		List<OrderDetal> order=dao.getOrder(orderid);
		
		if(order!=null) {
			return order;
		}else {
			return null;
		}
	}

}
