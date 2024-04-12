package com.jin.service;

import com.jin.pojo.Account;
import com.jin.pojo.Member;

public interface GymForgetService {
		
	public Member getMember(Account account);
	
	public Account checkAccount(String acc);
		
	public boolean updatePasswd(String uid,String passwd);
	
}
