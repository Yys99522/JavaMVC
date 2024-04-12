package com.jin.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.jin.pojo.Member;
import com.jin.service.GymMemberService;

@Controller
public class GymMemberController {
	
	@Autowired
	GymMemberService service;
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private ServletContext servletContext;
	
	@RequestMapping("/member")
	public String showMember() {
	    return "member";
	}
	
	@RequestMapping("/memberinfo")
	public String memberinfo() {
		return "memberinfo";
	}
	
	@RequestMapping("/newpasswd")
	public String newpasswd() {
		return "newpasswd";
	}
	
	@RequestMapping("/photo")
	public String photo( @RequestParam("file") MultipartFile file) {
	
		String uid=(String)session.getAttribute("uid");
		String contentType = file.getContentType();
		
		if("image/jpeg".equals(contentType)) {			
			if(file!=null) {
				String fileName = file.getOriginalFilename();
				String saveName = uid+fileName.substring(fileName.lastIndexOf("."));
				String uploadDir = servletContext.getRealPath("/img/member/");
				String path=uploadDir+saveName;
				
				session.setAttribute("path", "img/member/"+saveName);
				service.updateImg(uid, "img/member/"+saveName);
			
				  try {

					  file.transferTo(new File(path));
	                  System.out.println("File saved successfully" + path);

	              } catch (IOException e) {
	                    e.printStackTrace();
	                    return "File upload failed";
	              }
			}
		}
				
		return "member";
	}
	

	@RequestMapping("/infochange")
	public String infochange(@RequestParam(value = "phone", required = false)String phone,
			@RequestParam(value="birthdate", required = false) String birthdate,@RequestParam(value="sex", required = false)int sex,
			@RequestParam(value="county", required = false)String county,@RequestParam(value="district", required = false)String district,
			@RequestParam(value="address", required = false)String address,@RequestParam(value="email", required = false)String email) {
		
		Member member=(Member)session.getAttribute("member");
		
		member.setPhone(phone);
		member.setBirthdate(birthdate);
		member.setSex(sex);
		member.setCounty(county);
		member.setDistrict(district);
		member.setAddress(address);
		member.setEmail(email);
		
		service.updateMember(member);
		
		return "redirect:/memberinfo";
	}
	
	@RequestMapping("/changepasswd")
	public String newpasswd(@RequestParam(value="userpasswd", required = false)String passwd,
			@RequestParam(value="newpasswd", required = false)String newpasswd) {
		
		session.removeAttribute("check");
		String uid=(String)session.getAttribute("uid");
		boolean check=service.checkPasswd(uid, passwd);
		if(check) {
			service.updatePasswd(uid, newpasswd);
			return "redirect:/memberinfo";
		}else {
			session.setAttribute("check", "Invalid password");
			return "redirect:/newpasswd";
		}
	}
	

}
