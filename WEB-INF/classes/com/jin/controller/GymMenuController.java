package com.jin.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jin.pojo.Order;
import com.jin.pojo.OrderDetal;
import com.jin.pojo.Product;
import com.jin.service.GymMenuService;

@Controller
public class GymMenuController {
	
	@Autowired
	GymMenuService service;
	
	@Autowired
	private HttpSession session;
	
	@RequestMapping("/payment")
	public String payment() {
		return "payment";
	}
	
	@RequestMapping("/menu")
	public String menu() {
		
		List<Product> list=service.getProducts();
		int size=list.size();
		session.setAttribute("menu", list);
		session.setAttribute("menuSize", size);
		return "menu";
	}
	
	
	@RequestMapping("/cart")
	public String cart(@RequestParam(value="productList" ,required=false) String list) {
		String[] value=service.getCartList(list);
		int listSize=list.length();
		session.setAttribute("value", value);
		session.setAttribute("listSize", listSize);
		return "redirect:/payment";
	}
	
	@RequestMapping("/pay")
	public String pay(@RequestParam(value="cardNumber" ,required=false) String cardNumber,
			@RequestParam(value="payMethod")String method,@RequestParam(value="insrand") String insrand) {
		
		String num=(String)session.getAttribute("verifynum");
		if(num.equals(insrand)) {
			String uid=(String)session.getAttribute("uid");
			String[] productid=(String[])session.getAttribute("value");
			Order order=new Order(Integer.valueOf(uid),cardNumber);
			
			int orderid=service.pay(order, method, productid);
			List<OrderDetal> orderdetal=service.getOrder(orderid);
			
			
			session.setAttribute("orderdetal", orderdetal);
			session.removeAttribute("value");
			session.removeAttribute("verifynum");
			
			return "successOrder";
		}else {
			session.setAttribute("error", "驗證錯誤!");
			return "error";
		}
		
	}

}
