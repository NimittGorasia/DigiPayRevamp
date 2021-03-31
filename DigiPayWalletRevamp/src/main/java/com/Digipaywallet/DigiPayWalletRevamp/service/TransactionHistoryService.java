package com.Digipaywallet.DigiPayWalletRevamp.service;

import java.util.List;

import com.Digipaywallet.DigiPayWalletRevamp.vo.TransactionVO;

public interface TransactionHistoryService {

	public void addTransaction(TransactionVO transactionVO) throws Exception;
	
	public List<TransactionVO> viewPassbook(TransactionVO transactionVO) throws Exception;
}
