package com.jin.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jin.pojo.Account;
import com.jin.pojo.Member;
import com.jin.service.GymForgetService;

@Controller
public class GymForgetController {
	
	@Autowired
	GymForgetService service;
	
	@Autowired
	private HttpSession session;
	
	@RequestMapping("/verifyImg")
	public String verifyImg() {
		return "verifyImg";
	}
	
	@RequestMapping("/forgetpasswd")
	public String forgetpasswd(){
		return "forgetpasswd";
	}
	
	@RequestMapping("/resetpasswd")
	public String resetpasswd() {
		return "resetpasswd";
	}
	
	@RequestMapping("/forget")
	public String froget(@RequestParam(value = "username", required = false)String acc,
			@RequestParam(value = "email", required = false)String email) {
		
		Account account=service.checkAccount(acc);

		if(account==null) {
			session.setAttribute("check", "帳號不存在");
		}else {
			Member member=service.getMember(account);
			
			if(email.equals(member.getEmail()) || email.equals(member.getPhone())) {
				session.setAttribute("acc", account);
				return "redirect:/resetpasswd";
			}
			session.setAttribute("check", "手機/信箱不正確");			
		}
		
		return "redirect:/forgetpasswd";
		
	}
	
	@RequestMapping("/resetpwd")
	public String resetpwd(@RequestParam(value = "passwd", required = false)String passwd) {
		
		session.removeAttribute("check");
		Account account=(Account)session.getAttribute("acc");
		String uid=String.valueOf(account.getUid());
		
		service.updatePasswd(uid, passwd);
		session.removeAttribute("acc");
		
		return "redirect:/";
	}
	
	

}
