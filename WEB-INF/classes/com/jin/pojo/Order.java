package com.jin.pojo;

public class Order {

	
	private int orderid;
	private String orderdate;
	private int memberid;
	private String cardnumber;
	
	public Order() {
		
	}
	
	public Order(int orderid,String orderdate,int memberid,String cardnumber) {
		this.orderid=orderid;
		this.orderdate=orderdate;
		this.memberid=memberid;
		this.cardnumber=cardnumber;
	}
	
	public Order(int memberid,String cardnumber) {
		this.memberid=memberid;
		this.cardnumber=cardnumber;
	}
	
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderId) {
		this.orderid = orderId;
	}
	public String getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(String orderTime) {
		this.orderdate = orderTime;
	}
	public int getMemberid() {
		return memberid;
	}
	public void setMemberid(int memberId) {
		this.memberid = memberId;
	}
	public String getCardnumber() {
		return cardnumber;
	}
	public void setCardnumber(String cardNum) {
		this.cardnumber = cardNum;
	}
	
}
