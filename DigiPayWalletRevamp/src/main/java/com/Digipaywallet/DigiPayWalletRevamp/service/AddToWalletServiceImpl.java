package com.Digipaywallet.DigiPayWalletRevamp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Digipaywallet.DigiPayWalletRevamp.dao.AddToWalletRepository;
import com.Digipaywallet.DigiPayWalletRevamp.entity.AddToWalletDetails;
import com.Digipaywallet.DigiPayWalletRevamp.vo.PaymentsVO;

@Service
public class AddToWalletServiceImpl implements AddToWalletService {
	
	@Autowired
	private AddToWalletRepository addToWalletRepository;
	

	@Override
	public void addMoney(PaymentsVO	paymentsVO) throws Exception {
		AddToWalletDetails addToWalletDetails = new AddToWalletDetails();
		
		addToWalletDetails.setMerchantEmailId(paymentsVO.getMerchantEmailId());
		addToWalletDetails.setMerchantId(paymentsVO.getMerchantId());
		addToWalletDetails.setPayerId(paymentsVO.getPayerId());
		
		addToWalletDetails.setPaymentId(paymentsVO.getPaymentId());
		
		addToWalletDetails.setPaymentStatus(paymentsVO.getPaymentStatus());
		addToWalletDetails.setPurchasingAmount(Double.parseDouble(paymentsVO.getPurchasingAmount()));
		addToWalletDetails.setReceipientName(paymentsVO.getReceipientName());
		
		addToWalletDetails.setTransactionFee(Double.parseDouble(paymentsVO.getTransactionFee()));
		addToWalletDetails.setUserId(Long.parseLong(paymentsVO.getUserId()));
		
		addToWalletDetails.setCreatedOn(new java.util.Date());
		
		addToWalletRepository.save(addToWalletDetails);
		
	}

}
