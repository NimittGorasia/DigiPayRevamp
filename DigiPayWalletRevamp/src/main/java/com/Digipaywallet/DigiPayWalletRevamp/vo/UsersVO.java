package com.Digipaywallet.DigiPayWalletRevamp.vo;

public class UsersVO {
	private String userName;
	
	private String password;
	
	private String contact;
	
	private String email;
	
	private String statusCode;
	
	private String Message;

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}

	public UsersVO(String userName, String password, String contact, String email) {
		this.userName = userName;
		this.password = password;
		this.contact = contact;
		this.email = email;
	}
	
	public UsersVO() {
		
	}
	

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
