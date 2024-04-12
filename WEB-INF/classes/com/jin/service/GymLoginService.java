package com.jin.service;

import com.jin.pojo.Account;
import com.jin.pojo.Member;

public interface GymLoginService {
	
	public Account login(String acc, String pwd);
	
	public Member getMember(Account account);
	

}
