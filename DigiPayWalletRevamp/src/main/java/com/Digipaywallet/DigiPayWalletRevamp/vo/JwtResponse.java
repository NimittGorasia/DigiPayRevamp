package com.Digipaywallet.DigiPayWalletRevamp.vo;

import java.io.Serializable;

public class JwtResponse implements Serializable {

	private static final long serialVersionUID = -8091879091924046844L;
	private final String jwttoken;
	
	private final String expDate;

	public JwtResponse(String jwttoken,String expDate) {
		this.jwttoken = jwttoken;
		this.expDate = expDate; 
	}

	public String getToken() {
		return this.jwttoken;
	}

	public String getExpDate() {
		return expDate;
	}
}

