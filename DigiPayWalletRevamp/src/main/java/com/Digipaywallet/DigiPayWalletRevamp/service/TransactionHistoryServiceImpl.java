package com.Digipaywallet.DigiPayWalletRevamp.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Digipaywallet.DigiPayWalletRevamp.dao.TransactionRepository;
import com.Digipaywallet.DigiPayWalletRevamp.entity.TransactionHistory;
import com.Digipaywallet.DigiPayWalletRevamp.vo.TransactionVO;

@Service
public class TransactionHistoryServiceImpl implements TransactionHistoryService {
	
	@Autowired
	private TransactionRepository transactionRepository;

	@Override
	public void addTransaction(TransactionVO transactionVO) throws Exception {
		
		//SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
		TransactionHistory transactionHistory = new TransactionHistory();
		
		transactionHistory.setCreditDebit(transactionVO.getCreditDebit());
		transactionHistory.setPaymentTime(new java.util.Date());
		transactionHistory.setStatus(transactionVO.getTransactionStatus());
		transactionHistory.setAmount(Double.parseDouble(transactionVO.getPurchasingAmount()));
		transactionHistory.setPaidTo(transactionVO.getPaidTo());
		transactionHistory.setReceivedFrom(transactionVO.getReceivedFrom());
		
		transactionHistory.setCreatedOn(new java.util.Date());
		transactionHistory.setUserId(Long.parseLong(transactionVO.getUserId()));
		transactionRepository.save(transactionHistory);
		
	}
	
	@Override
	public List<TransactionVO> viewPassbook(TransactionVO transactionVO) throws Exception {
		List<TransactionHistory> transactionVOResultList = new ArrayList<>();
		List<TransactionVO> transactionVOList = new ArrayList<>();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			 transactionVOResultList = transactionRepository.findByUserId(Long.parseLong(transactionVO.getUserId()));
			 
			if (transactionVOResultList != null) {
				
				for(TransactionHistory transactionHistory : transactionVOResultList ) {
					TransactionVO transactionVOResult = new TransactionVO();
					
					transactionVOResult.setCreditDebit(transactionHistory.getCreditDebit());
					transactionVOResult.setPurchasingAmount(String.valueOf(transactionHistory.getAmount()));
					
					transactionVOResult.setPaymentTime(simpleDateFormat.format(transactionHistory.getPaymentTime()));
					transactionVOResult.setPaidTo(transactionHistory.getPaidTo());
					transactionVOResult.setReceivedFrom(transactionHistory.getReceivedFrom());
					
					transactionVOList.add(transactionVOResult);
				}	
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return transactionVOList;
	}

}
