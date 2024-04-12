package com.jin.service;

import com.jin.pojo.Account;
import com.jin.pojo.Member;

public interface GymRegisterService {
	
	public Account checkAccount(String acc);
	
	public boolean register(Member member);
	
	public boolean registerAccount(Account account);
	
	

}
