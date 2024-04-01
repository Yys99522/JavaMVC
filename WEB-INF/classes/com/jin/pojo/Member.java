package com.jin.pojo;

public class Member {
	
	private Integer id;
	private String membername;
	private String email;
	private String phone;
	private String birthdate;
	private Integer sex;
	private String county;
	private String district;
	private String address;
	private String img;
	
	public Member() {
		
	}
	
	public Member(int id,String name,String email,String phone,String birthdate,int sex,String county,String district,String address,String img) {
		this.id=id;
		this.membername=name;
		this.email=email;
		this.phone=phone;
		this.birthdate=birthdate;
		this.sex=sex;
		this.county=county;
		this.district=district;
		this.address=address;
		this.img=img;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMembername() {
		return membername;
	}
	public void setMembername(String name) {
		this.membername = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}

}
