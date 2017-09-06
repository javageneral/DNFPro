package com.dnf.entity;

public class CustAmount {
	long id;
	String phoneNum;
	int loanAmount;
	int usedAmount;
	int restAmount;
	String creditCardNum;
	
	
	public String getCreditCardNum() {
		return creditCardNum;
	}
	public void setCreditCardNum(String creditCardNum) {
		this.creditCardNum = creditCardNum;
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
	@Override
	public String toString() {
		return "CustAmount [id=" + id + ", phoneNum=" + phoneNum
				+ ", loanAmount=" + loanAmount + ", usedAmount=" + usedAmount
				+ ", restAmount=" + restAmount + ", creditCardNum="
				+ creditCardNum + "]";
	}
	
}
