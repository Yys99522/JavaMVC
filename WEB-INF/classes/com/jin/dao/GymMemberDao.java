package com.jin.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jin.pojo.Account;
import com.jin.pojo.Member;

@Repository
public class GymMemberDao {
	
	@Autowired
	GymDao dao;
	
	ResultSet rs = null;
	
	public int update(Member member) {
		dao.connect();
    	int result=0;
    	
    	int id=member.getId();
    	String name=member.getMembername();
    	String email=member.getEmail();
    	String phone=member.getPhone();
    	String birthdate=member.getBirthdate();
    	int sex=member.getSex();
    	String county=member.getCounty();
    	String district=member.getDistrict();
    	String address=member.getAddress();
    	String sql="update memberinfo set membername=?,email=?,phone=?,birthdate=?,sex=?,county=?,district=?,address=? where memberid=?";
    	
    	try {
    		PreparedStatement pstmt = dao.conn.prepareStatement(sql);
    		pstmt.setString(1, name);
    		pstmt.setString(2, email);
    		pstmt.setString(3, phone);
    		pstmt.setString(4, birthdate);
    		pstmt.setInt(5, sex);
    		pstmt.setString(6, county);
    		pstmt.setString(7, district);
    		pstmt.setString(8, address);
    		pstmt.setInt(9, id);
    		
    		result=pstmt.executeUpdate();
    		if(result>0) {
    			System.out.println("修改成功");
    		}
    		
    	}catch(SQLException e) {
    		System.out.println(e.getMessage());
    	}
    	
    	dao.close();
    	return result;
    }
	
	public int updateImg(String uid,String path) {
		dao.connect();
		int result=0;
		
		String sql="update memberinfo set img=? where memberid=?";
		
		try {
			PreparedStatement pstmt = dao.conn.prepareStatement(sql);
			pstmt.setString(1, path);
			pstmt.setString(2, uid);
			
			result=pstmt.executeUpdate();
			if(result>0) {
				System.out.println("修改成功");
			}
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
		dao.close();
		return result;
	}
	 
	public int updatePasswd(String uid,String passwd) {
	    dao.connect();	
		int result=0;
	    	String sql="update account set userpasswd=? where uid=?";
		
		try {
			PreparedStatement pstmt = dao.conn.prepareStatement(sql);
			pstmt.setString(1, passwd);
			pstmt.setString(2, uid);
			
			result=pstmt.executeUpdate();
			if(result>0) {
				System.out.println("修改成功");
			}
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
		dao.close();
		return result;
	}
	
	public Account checkPasswd(String uid,String passwd) {
    	dao.connect();
		Account result;
    	String sql="select * from account where uid=? and userpasswd=?";
    	
    	try {
    		PreparedStatement pstmt = dao.conn.prepareStatement(sql);
    		pstmt.setString(1, uid);
    		pstmt.setString(2, passwd);
    		
    		rs=pstmt.executeQuery();
    		if(rs.next()) {
    			result=new Account(rs.getInt("uid"),rs.getString("username"),rs.getString("userpasswd"));
    			dao.close();
    			return result;
    		}   		
    	}catch(SQLException e) {
    		System.out.println(e.getMessage());
    	}
    	
    	dao.close();
    	return null;
    }
}
