package com.dnf.utils;

/**
 * 封装json对象，所有返回结果都使用它
 */
public class Result<T> {

	private boolean success;// 是否成功标志

	private T data;// 成功时返回的数据

	private String error;// 错误信息
	
	private int page; //分页专用
	
	private int total; //分页专用

	public Result() {
	}

	// 成功时的构造器
	public Result(boolean success, T data) {
		this.success = success;
		this.data = data;
	}

	// 错误时的构造器
	public Result(boolean success, String error) {
		this.success = success;
		this.error = error;
	}
	
//	分页构造器
	public Result(boolean success, T data, int page, int total) {
		this.success = success;
		this.data = data;
		this.page = page;
		this.total = total;
	}

	@Override
	public String toString() {
		return "{\"success\":\"" + success + "\",\"data\":\"" + data
				+ "\",\"error\":\"" + error + "\"} ";
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
	
	
}