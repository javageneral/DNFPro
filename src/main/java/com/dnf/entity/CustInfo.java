package com.dnf.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;


public class CustInfo {
	long id;
	String phoneNum;
	String name;
	String idCardNum;
	String city;
	String cityCode;
	String sex;
	String address;
	String idCardUpPhoto;
	String idCardDownPhoto;
	String state;
	Date createDate;
	Date reviewDate;
	String errorLog;
	
	public String getErrorLog() {
		return errorLog;
	}
	public void setErrorLog(String errorLog) {
		this.errorLog = errorLog;
	}
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdCardNum() {
		return idCardNum;
	}
	public void setIdCardNum(String idCardNum) {
		this.idCardNum = idCardNum;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getIdCardUpPhoto() {
		return idCardUpPhoto;
	}
	public void setIdCardUpPhoto(String idCardUpPhoto) {
		this.idCardUpPhoto = idCardUpPhoto;
	}
	public String getIdCardDownPhoto() {
		return idCardDownPhoto;
	}
	public void setIdCardDownPhoto(String idCardDownPhoto) {
		this.idCardDownPhoto = idCardDownPhoto;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}
	@Override
	public String toString() {
		return "CustInfo [id=" + id + ", phoneNum=" + phoneNum + ", name="
				+ name + ", idCardNum=" + idCardNum + ", city=" + city
				+ ", cityCode=" + cityCode + ", sex=" + sex + ", address="
				+ address + ", idCardUpPhoto=" + idCardUpPhoto
				+ ", idCardDownPhoto=" + idCardDownPhoto + ", state=" + state
				+ ", createDate=" + createDate + ", reviewDate=" + reviewDate
				+ ", errorLog=" + errorLog + "]";
	}
	
}
