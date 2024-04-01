package com.jin.service;

import com.jin.pojo.Account;
import com.jin.pojo.Member;

public interface GymService {
	
	public Account login(String acc,String pwd);
	
	public Member getMember(Account account);
	
	public boolean register(Member member);
	
	public Account checkAccount(String acc);
	
	public boolean checkPasswd(String uid,String passwd);
	
	public boolean updatePasswd(String uid,String passwd);
	
	public boolean registerAccount(Account account);
	
	public boolean updateMember(Member member);
	
	public boolean updateImg(String uid,String path);

}
