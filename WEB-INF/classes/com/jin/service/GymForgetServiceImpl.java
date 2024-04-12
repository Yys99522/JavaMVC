package com.jin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jin.pojo.Account;
import com.jin.pojo.Member;

@Service
public class GymForgetServiceImpl implements GymForgetService{
	
	@Autowired
	GymLoginService login;
	@Autowired
	GymMemberService member;
	@Autowired
	GymRegisterService register;

	@Override
	public Member getMember(Account account) {
		
		Member result=login.getMember(account);
		if(result!=null) {
			return result;
		}
		
		return null;
	}	

	@Override
	public Account checkAccount(String acc) {		
		
		Account account=register.checkAccount(acc);
		if(account!=null) {
			return account;
		}
		
		return null;
	}
	
	@Override
	public boolean updatePasswd(String uid,String passwd) {
		boolean result=false;
		
		result=member.updatePasswd(uid, passwd);
		
		return result;
	}

}
