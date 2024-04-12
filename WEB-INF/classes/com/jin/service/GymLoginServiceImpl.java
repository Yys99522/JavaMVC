package com.jin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jin.dao.GymLoginDao;
import com.jin.pojo.Account;
import com.jin.pojo.Member;

@Service
public class GymLoginServiceImpl implements GymLoginService {
	
	@Autowired
	GymLoginDao dao;

	@Override
	public Account login(String acc, String pwd) {
		Account result=dao.login(acc, pwd);
		
		if(result!=null) {
			return result;
		}
		
		return null;
	}

	@Override
	public Member getMember(Account account) {
		Member result=dao.getMember(account);
		
		if(result!=null) {
			return result;
		}
		return null;
	}

}
