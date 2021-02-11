package com.Digipaywallet.DigiPayWalletRevamp.vo;

import java.io.Serializable;

public class JwtResponse implements Serializable {

	private static final long serialVersionUID = -8091879091924046844L;
	private final String jwttoken;
	
	private final String expiresIn;

	public JwtResponse(String jwttoken,String expiresIn) {
		this.jwttoken = jwttoken;
		this.expiresIn = expiresIn; 
	}

	public String getToken() {
		return this.jwttoken;
	}

	public String getExpiresIn() {
		return expiresIn;
	}

}

