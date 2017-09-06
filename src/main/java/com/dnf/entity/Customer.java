package com.dnf.entity;

public class Customer {

	private long id;
	private String phoneNum;
	private String password;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", phoneNum=" + phoneNum + ", password="
				+ password + "]";
	}

}
