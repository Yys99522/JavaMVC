package com.jin.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jin.pojo.Account;
import com.jin.pojo.Member;

@Repository
public class GymLoginDao {
	
	@Autowired
	GymDao dao;
	
	ResultSet rs = null;
	
	public Account login(String acc,String pwd) {
		dao.connect();
    	Account result;
    	String sql="select * from account where username=? and userpasswd=?";
    	
    	try {
    		PreparedStatement pstmt = dao.conn.prepareStatement(sql);
    		pstmt.setString(1, acc);
    		pstmt.setString(2, pwd);
    		
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
	
	
	public Member getMember(Account account) {
    	dao.connect();
		Member result;
    	int id=account.getUid();
    	String sql="select * from memberinfo where memberid=?";
    	
    	try {
    		PreparedStatement pstmt = dao.conn.prepareStatement(sql);
    		pstmt.setInt(1, id);
    		
    		rs=pstmt.executeQuery();
    		if(rs.next()) {
    			result=new Member(rs.getInt("memberid"),rs.getString("membername"),rs.getString("email"),rs.getString("phone"),
    					rs.getString("birthdate"),rs.getInt("sex"),rs.getString("county"),rs.getString("district"),rs.getString("address"),rs.getString("img"));
    			
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
