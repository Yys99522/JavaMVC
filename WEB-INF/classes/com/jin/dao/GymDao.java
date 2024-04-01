package com.jin.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Repository;

import com.jin.pojo.Account;
import com.jin.pojo.Member;


@Repository
public class GymDao {
	
	private String sDriver = "com.mysql.cj.jdbc.Driver";
	private String url="jdbc:mysql://localhost/gym?useUnicode=true&characterEncoding=UTF-8";
	private String acc="root";
	private String pwd="1234";
	
	Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    
    public Account login(String acc,String pwd) {
    	Account result;
    	String sql="select * from account where username=? and userpasswd=?";
    	
    	try {
    		PreparedStatement pstmt = conn.prepareStatement(sql);
    		pstmt.setString(1, acc);
    		pstmt.setString(2, pwd);
    		
    		rs=pstmt.executeQuery();
    		if(rs.next()) {
    			result=new Account(rs.getInt("uid"),rs.getString("username"),rs.getString("userpasswd"));
    			return result;
    		}   		
    	}catch(SQLException e) {
    		System.out.println(e.getMessage());
    	}
    	
    	return null;
    }
    
    public Member getMember(Account account) {
    	Member result;
    	int id=account.getUid();
    	String sql="select * from memberinfo where memberid=?";
    	
    	try {
    		PreparedStatement pstmt = conn.prepareStatement(sql);
    		pstmt.setInt(1, id);
    		
    		rs=pstmt.executeQuery();
    		if(rs.next()) {
    			result=new Member(rs.getInt("memberid"),rs.getString("membername"),rs.getString("email"),rs.getString("phone"),
    					rs.getString("birthdate"),rs.getInt("sex"),rs.getString("county"),rs.getString("district"),rs.getString("address"),rs.getString("img"));
    			
    			return result;
    		}
  		
    	}catch(SQLException e) {
    		System.out.println(e.getMessage());
    	}
    	
    	return null;
    }
    
    public Account checkAccount(String acc) {
    	Account result;
    	String sql="select * from account where username=?";
    	
    	try {
    		PreparedStatement pstmt = conn.prepareStatement(sql);
    		pstmt.setString(1, acc);
    		
    		rs=pstmt.executeQuery();
    		if(rs.next()) {
    			result=new Account(rs.getInt("uid"),rs.getString("username"),rs.getString("userpasswd"));
    			return result;
    		}   		
    	}catch(SQLException e) {
    		System.out.println(e.getMessage());
    	}
    	
    	return null;
    }
    
    public Account checkPasswd(String uid,String passwd) {
    	Account result;
    	String sql="select * from account where uid=? and userpasswd=?";
    	
    	try {
    		PreparedStatement pstmt = conn.prepareStatement(sql);
    		pstmt.setString(1, uid);
    		pstmt.setString(2, passwd);
    		
    		rs=pstmt.executeQuery();
    		if(rs.next()) {
    			result=new Account(rs.getInt("uid"),rs.getString("username"),rs.getString("userpasswd"));
    			return result;
    		}   		
    	}catch(SQLException e) {
    		System.out.println(e.getMessage());
    	}
    	
    	return null;
    }
    
    public int registerAccount(Account account) {
    	int result=0;

    	String username=account.getUsername();
    	String passwd=account.getUserpasswd();
    	String sql="insert into account values(?,?,0,'m')";
    	
    	try {
    		PreparedStatement pstmt = conn.prepareStatement(sql);
    		pstmt.setString(1, username);
    		pstmt.setString(2, passwd);
    		
    		result=pstmt.executeUpdate();
    		if(result>0) {
    			System.out.println("新增成功");
    		}   		
    	}catch(SQLException e) {
    		System.out.println(e.getMessage());
    	}
    	
    	return result;
    }
    
    public int register(Member member) {
    	int result=0;
    	
    	String name=member.getMembername();
    	String email=member.getEmail();
    	String phone=member.getPhone();
    	String birthdate=member.getBirthdate();
    	int sex=member.getSex();
    	String county=member.getCounty();
    	String district=member.getDistrict();
    	String address=member.getAddress();
    	String img=member.getImg();
    	String sql="insert into memberinfo values(0,?,?,?,?,?,?,?,?,?,0)";
    	
    	try {
    		PreparedStatement pstmt = conn.prepareStatement(sql);
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
    	
    	return result;
    }
    
    public int updatePasswd(String uid,String passwd) {
    	int result=0;
    	String sql="update account set userpasswd=? where uid=?";
    	
    	try {
    		PreparedStatement pstmt = conn.prepareStatement(sql);
    		pstmt.setString(1, passwd);
    		pstmt.setString(2, uid);
    		
    		result=pstmt.executeUpdate();
    		if(result>0) {
    			System.out.println("修改成功");
    		}
    		
    	}catch(SQLException e) {
    		System.out.println(e.getMessage());
    	}
    	
    	return result;
    }
    
    public int updateImg(String uid,String path) {
    	int result=0;
    	
    	String sql="update memberinfo set img=? where memberid=?";
    	
    	try {
    		PreparedStatement pstmt = conn.prepareStatement(sql);
    		pstmt.setString(1, path);
    		pstmt.setString(2, uid);
    		
    		result=pstmt.executeUpdate();
    		if(result>0) {
    			System.out.println("修改成功");
    		}
    		
    	}catch(SQLException e) {
    		System.out.println(e.getMessage());
    	}
    	
    	return result;
    }
    
    public int update(Member member) {
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
    		PreparedStatement pstmt = conn.prepareStatement(sql);
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
    	
    	return result;
    }
    
    public void connect() {
    	
    	try   //載入JDBC driver 
	    {     
	        Class.forName(sDriver);
	    }
	    catch(Exception e){
	        System.out.println("無法載入驅動程式");
	    }
  
	    try{
	    	
	        conn = DriverManager.getConnection(url,acc,pwd);
	        stmt = conn.createStatement();
	    }
	    catch(SQLException e){
	        System.out.println(e.getMessage());
		}
    }

    public void close() {
		
		 try{
	           stmt.close(); 
	           conn.close(); 
	       }
	       catch( SQLException e ){ 
	    	   System.out.println(e.getMessage());
	       }
	}

}
