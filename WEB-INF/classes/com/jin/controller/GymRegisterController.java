package com.jin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;

import com.jin.pojo.Account;
import com.jin.pojo.Member;
import com.jin.service.GymService;


@Controller
public class GymRegisterController {
	
	@Autowired
	GymService service;
	
	@Autowired
	private HttpSession session;

	
	@RequestMapping("/register")
	public String register() {
		return "register";
	}
	
	@RequestMapping("/inputdata")
	public String inputdata(@ModelAttribute Member member, @ModelAttribute Account account) {
		
		Account checkAcc=service.checkAccount(account.getUsername());
		
		if(checkAcc==null) {
			boolean registerMember=service.register(member);
			boolean registerAcc=service.registerAccount(account);
			
			if(registerMember && registerAcc) {
				return "redirect:/";
			}else {
				session.setAttribute("error", "invalid data");
				return "redirect:/register";
			}
		}else {
			session.setAttribute("checkAcc", "account already exists");
			return "redirect:/register";
		}
		
	}


}
