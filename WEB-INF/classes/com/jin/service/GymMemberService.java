package com.jin.service;

import com.jin.pojo.Member;

public interface GymMemberService {
	
	public boolean updateMember(Member member);
	
	public boolean updateImg(String uid,String path);
	
	public boolean updatePasswd(String uid,String passwd);
	
	public boolean checkPasswd(String uid,String passwd);
	

}
