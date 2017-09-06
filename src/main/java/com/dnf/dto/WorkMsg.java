package com.dnf.dto;

public class WorkMsg {
	String custName;
	String phoneNum;
	String creditCardId;
	String idCardNum;
	String orderId;
	String orderAmount;
	String videoUrl;
	String cityCode;
	String loanPurpose;
	String loanTime;
	String createDate;
	String msgType;
	String state;
	public String getMsgType() {
		return msgType;
	}
	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getCreditCardId() {
		return creditCardId;
	}
	public void setCreditCardId(String creditCardId) {
		this.creditCardId = creditCardId;
	}
	public String getIdCardNum() {
		return idCardNum;
	}
	public void setIdCardNum(String idCardNum) {
		this.idCardNum = idCardNum;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getOrderAmount() {
		return orderAmount;
	}
	public void setOrderAmount(String orderAmount) {
		this.orderAmount = orderAmount;
	}
	public String getVideoUrl() {
		return videoUrl;
	}
	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	public String getLoanPurpose() {
		return loanPurpose;
	}
	public void setLoanPurpose(String loanPurpose) {
		this.loanPurpose = loanPurpose;
	}
	public String getLoanTime() {
		return loanTime;
	}
	public void setLoanTime(String loanTime) {
		this.loanTime = loanTime;
	}
	
	
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public WorkMsg() {
		super();
	}
	public WorkMsg(String custName, String phoneNum, String creditCardId,
			String idCardNum, String orderId, String orderAmount,
			String videoUrl, String cityCode, String loanPurpose,
			String loanTime, String createDate, String msgType) {
		super();
		this.custName = custName;
		this.phoneNum = phoneNum;
		this.creditCardId = creditCardId;
		this.idCardNum = idCardNum;
		this.orderId = orderId;
		this.orderAmount = orderAmount;
		this.videoUrl = videoUrl;
		this.cityCode = cityCode;
		this.loanPurpose = loanPurpose;
		this.loanTime = loanTime;
		this.createDate = createDate;
		this.msgType = msgType;
	}
	@Override
	public String toString() {
		return "WorkMsg [custName=" + custName + ", phoneNum=" + phoneNum
				+ ", creditCardId=" + creditCardId + ", idCardNum=" + idCardNum
				+ ", orderId=" + orderId + ", orderAmount=" + orderAmount
				+ ", videoUrl=" + videoUrl + ", cityCode=" + cityCode
				+ ", loanPurpose=" + loanPurpose + ", loanTime=" + loanTime
				+ ", createDate=" + createDate + ", msgType=" + msgType
				+ ", state=" + state + "]";
	}
	
}
