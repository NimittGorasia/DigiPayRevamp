package com.Digipaywallet.DigiPayWalletRevamp.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface PaymentsService {
	
	public Map<String, Object> createPayment(String sum);
	
	public Map<String, Object> completePayment(HttpServletRequest req);

}
