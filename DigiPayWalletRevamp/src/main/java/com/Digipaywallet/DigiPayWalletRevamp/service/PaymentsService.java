package com.Digipaywallet.DigiPayWalletRevamp.service;

import java.util.Map;

import com.Digipaywallet.DigiPayWalletRevamp.vo.PaymentsVO;
import com.Digipaywallet.DigiPayWalletRevamp.vo.TransactionVO;

public interface PaymentsService {
	
	public Map<String, Object> createPayment(String sum);
	
	public Map<String, Object> completePayment(PaymentsVO paymentsVO) throws Exception;
	
	public String updateBalance(TransactionVO transactionVO) throws Exception;
	
}
