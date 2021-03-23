package com.Digipaywallet.DigiPayWalletRevamp.service;

import java.util.Map;

import com.Digipaywallet.DigiPayWalletRevamp.vo.PaymentsVO;

public interface PaymentsService {
	
	public Map<String, Object> createPayment(String sum);
	
	public Map<String, Object> completePayment(PaymentsVO paymentsVO);

}
