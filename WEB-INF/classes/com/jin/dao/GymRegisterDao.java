package com.jin.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jin.pojo.Account;
import com.jin.pojo.Member;

@Repository
public class GymRegisterDao {
	
	@Autowired
	GymDao dao;
	
	ResultSet rs = null;
	
	public Account checkAccount(String acc) {
    	dao.connect();
		Account result;
    	String sql="select * from account where username=?";
    	
    	try {
    		PreparedStatement pstmt = dao.conn.prepareStatement(sql);
    		pstmt.setString(1, acc);
    		
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
	
	public int register(Member member) {
		dao.connect();
    	int result=0;
    	
    	String name=member.getMembername();
    	String email=member.getEmail();
    	String phone=member.getPhone();
    	String birthdate=member.getBirthdate();
    	int sex=member.getSex();
    	String county=member.getCounty();
    	String district=member.getDistrict();
    	String address=member.getAddress();
    	String img="img/member/0.svg";
    	String sql="insert into memberinfo values(0,?,?,?,?,?,?,?,?,?,0)";
    	
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
    		pstmt.setString(9, img);
    		
    		result=pstmt.executeUpdate();
    		if(result>0) {
    			System.out.println("新增成功");
    		}
    		
    	}
    	catch(SQLException e) {
    		System.out.println(e.getMessage());
    	}
    	
    	dao.close();
    	return result;
    }
	
	public int registerAccount(Account account) {
    	dao.connect();
		int result=0;

    	String username=account.getUsername();
    	String passwd=account.getUserpasswd();
    	String sql="insert into account values(?,?,0,'m')";
    	
    	try {
    		PreparedStatement pstmt = dao.conn.prepareStatement(sql);
    		pstmt.setString(1, username);
    		pstmt.setString(2, passwd);
    		
    		result=pstmt.executeUpdate();
    		if(result>0) {
    			System.out.println("新增成功");
    		}   		
    	}catch(SQLException e) {
    		System.out.println(e.getMessage());
    	}
    	
    	dao.close();
    	return result;
    }

}
