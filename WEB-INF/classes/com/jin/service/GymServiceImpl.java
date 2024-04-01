package com.jin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jin.dao.GymDao;
import com.jin.pojo.Account;
import com.jin.pojo.Member;

@Service
public class GymServiceImpl implements GymService{
	
	@Autowired
	GymDao dao;

	@Override
	public Account login(String acc, String pwd) {
		dao.connect();
		Account result=dao.login(acc, pwd);
		
		if(result!=null) {
			dao.close();
			return result;
		}
		
		dao.close();
		return null;
	}

	@Override
	public Member getMember(Account account) {
		
		dao.connect();
		Member result=dao.getMember(account);
		
		if(result!=null) {
			dao.close();
			return result;
		}
		
		dao.close();
		return null;
	}

	@Override
	public boolean register(Member member) {
		boolean result=false;
		
		dao.connect();
		int row=dao.register(member);
		if(row>0) {
			result=true;
		}
		dao.close();
		
		return result;
	}
	
	

	@Override
	public Account checkAccount(String acc) {
		
		dao.connect();
		Account account=dao.checkAccount(acc);
		if(account!=null) {
			return account;
		}
		
		dao.close();
		
		return null;
	}
	
	@Override
	public boolean checkPasswd(String uid,String passwd) {
		boolean result=false;
		
		dao.connect();
		Account account=dao.checkPasswd(uid, passwd);
		if(account!=null) {
			result=true;
		}
		
		dao.close();
		
		return result;
	}

	@Override
	public boolean registerAccount(Account account) {
		boolean result=false;
		
		dao.connect();
		int row=dao.registerAccount(account);
		if(row>0) {
			result=true;
		}
		dao.close();
		
		return result;
	}

	@Override
	public boolean updateMember(Member member) {
		boolean result=false;
		
		dao.connect();
		int row=dao.update(member);
		if(row>0) {
			result=true;
		}
		dao.close();
		
		return result;
	}
	
	@Override
	public boolean updateImg(String uid,String path) {
		boolean result=false;
		
		dao.connect();
		int row=dao.updateImg(uid, path);
		if(row>0) {
			result=true;
		}
		dao.close();
		
		return result;
	}
	
	@Override
	public boolean updatePasswd(String uid,String passwd) {
		boolean result=false;
		
		dao.connect();
		int row=dao.updatePasswd(uid, passwd);
		if(row>0) {
			result=true;
		}
		dao.close();
		
		return result;
	}

}
