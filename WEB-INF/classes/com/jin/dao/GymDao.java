package com.jin.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Repository;



@Repository
public class GymDao {
	
	private String sDriver = "com.mysql.cj.jdbc.Driver";
	private String url="jdbc:mysql://localhost/gym?useUnicode=true&characterEncoding=UTF-8";
	private String acc="root";
	private String pwd="1234";
	
	Connection conn = null;
    Statement stmt = null;    

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
