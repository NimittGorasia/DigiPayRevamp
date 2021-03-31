package com.Digipaywallet.DigiPayWalletRevamp.service;

import com.Digipaywallet.DigiPayWalletRevamp.vo.PaymentsVO;

public interface AddToWalletService {

	public void addMoney(PaymentsVO	paymentsVO) throws Exception;
}
