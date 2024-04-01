package com.jin.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jin.pojo.Account;
import com.jin.pojo.Member;
import com.jin.service.GymService;


@Controller
public class GymLoginController {
	
	@Autowired
	GymService service;
	
	@Autowired
	private HttpSession session;
	
	@RequestMapping("/login")
	public String login(@RequestParam(value = "username", required = false)String acc,
			@RequestParam(value = "userpasswd", required = false)String pwd) {
		
		Account account=service.login(acc, pwd);
		if(account!=null) {
			Member member=service.getMember(account);
			String uid=String.valueOf(member.getId());
			String imgpath=member.getImg();
			session.setAttribute("member", member);
			session.setAttribute("uid", uid);
			session.setAttribute("imgpath", imgpath);
			session.setAttribute("login", "in");
			return "redirect:/member";
		}else {
			 session.setAttribute("error", "Invalid username or password");
	         return "redirect:/";
		}

	}
	
	@RequestMapping("/logout")
	public String logout() {
		session.removeAttribute("login");
		session.removeAttribute("member");
		session.removeAttribute("uid");
		session.removeAttribute("imgpath");
		session.removeAttribute("path");
		return "redirect:/";
	}

}
