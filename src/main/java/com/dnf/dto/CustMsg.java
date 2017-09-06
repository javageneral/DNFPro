package com.dnf.dto;

import java.util.Date;

import com.dnf.entity.CustAmount;
import com.dnf.entity.CustInfo;
import com.dnf.entity.Customer;
import com.dnf.utils.RegExputils;

public class CustMsg {
	long id;
	String phoneNum;
	String name;
	String idCardNum;
	String city;
	String cityCode;
	String sex;
	String creditCardNum;
	String address;
	String idCardUpPhoto;
	String idCardDownPhoto;
	int loanAmount;
	int usedAmount;
	int restAmount;
	String state;
	String createDate;
	String reviewDate;
	String errorLog;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(String reviewDate) {
		this.reviewDate = reviewDate;
	}
	public String getErrorLog() {
		return errorLog;
	}
	public void setErrorLog(String errorLog) {
		this.errorLog = errorLog;
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
	public String getCreditCardNum() {
		return creditCardNum;
	}
	public void setCreditCardNum(String creditCardNum) {
		this.creditCardNum = creditCardNum;
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
	
	public int getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(int loanAmount) {
		this.loanAmount = loanAmount;
	}
	public int getUsedAmount() {
		return usedAmount;
	}
	public void setUsedAmount(int usedAmount) {
		this.usedAmount = usedAmount;
	}
	public int getRestAmount() {
		return restAmount;
	}
	public void setRestAmount(int restAmount) {
		this.restAmount = restAmount;
	}
	public CustMsg() {
		super();
	}
	

	
	public CustMsg(long id, String phoneNum, String name, String idCardNum,
			String city, String cityCode, String sex, String creditCardNum,
			String address, String idCardUpPhoto, String idCardDownPhoto,
			int loanAmount, int usedAmount, int restAmount,
			String state, String createDate, String reviewDate, String errorLog) {
		super();
		this.id = id;
		this.phoneNum = phoneNum;
		this.name = name;
		this.idCardNum = idCardNum;
		this.city = city;
		this.cityCode = cityCode;
		this.sex = sex;
		this.creditCardNum = creditCardNum;
		this.address = address;
		this.idCardUpPhoto = idCardUpPhoto;
		this.idCardDownPhoto = idCardDownPhoto;
		this.loanAmount = loanAmount;
		this.usedAmount = usedAmount;
		this.restAmount = restAmount;
		this.state = state;
		this.createDate = createDate;
		this.reviewDate = reviewDate;
		this.errorLog = errorLog;
	}
	public CustMsg(Customer customer, CustInfo info, CustAmount amount){
		this.id = customer.getId();
		this.phoneNum = customer.getPhoneNum();
		this.name = info.getName();
		this.idCardNum = info.getIdCardNum();
		this.city = info.getCity();
		this.cityCode = info.getCityCode();
		this.sex = info.getSex();
		this.creditCardNum = amount.getCreditCardNum();
		this.address = info.getAddress();
		this.idCardUpPhoto = info.getIdCardUpPhoto();
		this.idCardDownPhoto = info.getIdCardDownPhoto();
		this.loanAmount = amount.getLoanAmount();
		this.usedAmount = amount.getUsedAmount();
		this.restAmount = amount.getRestAmount();
		this.state = info.getState();
		this.errorLog = info.getErrorLog();
		this.createDate = RegExputils.formatDate(info.getCreateDate());
		this.reviewDate = RegExputils.formatDate(info.getReviewDate());
	}
	
	public CustMsg(CustInfo info, CustAmount amount){
		this.phoneNum = info.getPhoneNum();
		this.name = info.getName();
		this.idCardNum = info.getIdCardNum();
		this.city = info.getCity();
		this.cityCode = info.getCityCode();
		this.sex = info.getSex();
		this.address = info.getAddress();
		this.idCardUpPhoto = info.getIdCardUpPhoto();
		this.idCardDownPhoto = info.getIdCardDownPhoto();
		this.state = info.getState();
		this.errorLog = info.getErrorLog();
		this.createDate = RegExputils.formatDate(info.getCreateDate());
		this.reviewDate = RegExputils.formatDate(info.getReviewDate());
		this.loanAmount = amount.getLoanAmount();
		this.usedAmount = amount.getUsedAmount();
		this.restAmount = amount.getRestAmount();
		this.creditCardNum = amount.getCreditCardNum();
	}
	
	@Override
	public String toString() {
		return "CustMsg [id=" + id + ", phoneNum=" + phoneNum + ", name="
				+ name + ", idCardNum=" + idCardNum + ", city=" + city
				+ ", cityCode=" + cityCode + ", sex=" + sex
				+ ", creditCardNum=" + creditCardNum + ", address=" + address
				+ ", idCardUpPhoto=" + idCardUpPhoto + ", idCardDownPhoto="
				+ idCardDownPhoto + ", loanAmount=" + loanAmount
				+ ", usedAmount=" + usedAmount + ", restAmount=" + restAmount
				+ "]";
	}
	
	
	public void updateAmount(CustAmount amount){
		this.loanAmount = amount.getLoanAmount();
		this.usedAmount = amount.getUsedAmount();
		this.restAmount = amount.getRestAmount();
		this.creditCardNum = amount.getCreditCardNum();
	}
	
	
}
