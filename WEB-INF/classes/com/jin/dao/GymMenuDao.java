package com.jin.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jin.pojo.Order;
import com.jin.pojo.OrderDetal;
import com.jin.pojo.Product;

@Repository
public class GymMenuDao {
	
	@Autowired
	GymDao dao;
	
	ResultSet rs = null;
	
	public List<Product> getProducts() {
		dao.connect();
		String sql="select * from products";
		List<Product> list=new ArrayList<Product>();
		try {
			rs=dao.conn.createStatement().executeQuery(sql);
			while(rs.next()) {
				int productId=rs.getInt("productid");
				String productName=rs.getString("productname");
				String descript=rs.getString("descript");
				double price=rs.getDouble("price");
				String category=rs.getString("category");
				String image=rs.getString("image");
				
				Product product=new Product(productId,productName,descript,price,category,image);
				list.add(product);
			}
			
			return list;
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
		
		dao.close();
		return null;
	}
	
	public Integer pay(Order main,String method,String[] productId) {
		dao.connect();
		String sql1="insert into ordermain(orderdate,memberid,cardnumber) values(?,?,?)";
		String sql2="select orderid from ordermain where orderdate=?";
		String sql3="insert into orderdetal values(?,?,(select price from products where productid=?),1,?,?)";
		int orderid=0;
		
		try {
    		PreparedStatement pstmt1 = dao.conn.prepareStatement(sql1);
    		PreparedStatement pstmt2 = dao.conn.prepareStatement(sql2);
    		PreparedStatement pstmt3 = dao.conn.prepareStatement(sql3);
    		
    		pstmt1.setString(1, main.getOrderdate());
    		pstmt1.setInt(2, main.getMemberid());
    		pstmt1.setString(3, main.getCardnumber());
    		pstmt1.executeUpdate();

    		pstmt2.setString(1, main.getOrderdate());
    		rs=pstmt2.executeQuery();
    		if(rs.next()) {
    			orderid=Integer.valueOf(rs.getString("orderid"));
    			
    			int i=0;
        		String pId;
        		while(i<productId.length) {
        			pId=productId[i];
        			pstmt3.setInt(1,orderid );
        			pstmt3.setString(2, pId);
        			pstmt3.setString(3, pId);
        			pstmt3.setString(4, method);
        			if(method.equals("craditCard")) {
        				pstmt3.setString(5, "true");
        			}else {
        				pstmt3.setString(5, "false");
        			}
        			
        			pstmt3.executeUpdate();
        			i++;
        		}
    		}
    		
    		return orderid;
    	}catch(SQLException e) {
    		System.out.println(e.getMessage());
    	}
		
		dao.close();
		return null;
	}
	
	
	public List<OrderDetal> getOrder(int orderid) {
		dao.connect();
		
		String sql="select * from orderdetal where orderid=?";
		List<OrderDetal> list=new ArrayList<OrderDetal>();
		try {
    		PreparedStatement pstmt = dao.conn.prepareStatement(sql);
    		pstmt.setInt(1, orderid);
    		rs=pstmt.executeQuery();
    		while(rs.next()) {
    			OrderDetal order=new OrderDetal();
    			order.setOrderid(orderid);
    			order.setPaymethod(rs.getString("paymentmethod"));
    			order.setPaystatus(rs.getString("paymentstatus"));
    			order.setPrice(rs.getDouble("price"));
    			order.setProductid(rs.getInt("productid"));
    			order.setQuantity(rs.getInt("quantity"));
    			
    			list.add(order);
    		}
    		
    		return list;
    		
    	}catch(SQLException e) {
    		System.out.println(e.getMessage());
    	}
		
		dao.close();
		
		return null;
		
	}

}
