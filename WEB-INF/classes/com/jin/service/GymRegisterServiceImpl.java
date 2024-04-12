package com.jin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jin.dao.GymRegisterDao;
import com.jin.pojo.Account;
import com.jin.pojo.Member;

@Service
public class GymRegisterServiceImpl implements GymRegisterService {

	@Autowired
	GymRegisterDao dao;
	
	@Override
	public Account checkAccount(String acc) {
		Account account=dao.checkAccount(acc);
		if(account!=null) {
			return account;
		}
		
		return null;
	}

	@Override
	public boolean register(Member member) {
		boolean result=false;

		int row=dao.register(member);
		if(row>0) {
			result=true;
		}
		
		return result;
	}

	@Override
	public boolean registerAccount(Account account) {
		boolean result=false;
		
		int row=dao.registerAccount(account);
		if(row>0) {
			result=true;
		}
		
		return result;
	}

}
