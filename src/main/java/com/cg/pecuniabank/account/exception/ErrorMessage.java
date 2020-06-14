package com.cg.pecuniabank.account.exception;

public class ErrorMessage {
	private int statusCode;
	private String errorMessage;
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public void setPath(String servletPath) {
		// TODO Auto-generated method stub
		
	}
	

}
