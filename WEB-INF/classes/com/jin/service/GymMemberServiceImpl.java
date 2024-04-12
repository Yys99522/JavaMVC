package com.jin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jin.dao.GymMemberDao;
import com.jin.pojo.Account;
import com.jin.pojo.Member;

@Service
public class GymMemberServiceImpl implements GymMemberService {
	
	@Autowired
	GymMemberDao dao;
	
	@Override
	public boolean updateMember(Member member) {
		boolean result=false;
		
		int row=dao.update(member);
		if(row>0) {
			result=true;
		}
		
		return result;
	}

	@Override
	public boolean updateImg(String uid, String path) {
		boolean result=false;		

		int row=dao.updateImg(uid, path);
		if(row>0) {
			result=true;
		}
		
		return result;
	}

	@Override
	public boolean updatePasswd(String uid, String passwd) {
		boolean result=false;

		int row=dao.updatePasswd(uid, passwd);
		if(row>0) {
			result=true;
		}
		
		return result;
	}

	@Override
	public boolean checkPasswd(String uid, String passwd) {
		boolean result=false;

		Account account=dao.checkPasswd(uid, passwd);
		if(account!=null) {
			result=true;
		}
		
		return result;
	}

}
