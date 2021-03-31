package com.Digipaywallet.DigiPayWalletRevamp.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.Digipaywallet.DigiPayWalletRevamp.service.PaymentsService;
import com.Digipaywallet.DigiPayWalletRevamp.service.TransactionHistoryService;
import com.Digipaywallet.DigiPayWalletRevamp.vo.PaymentsVO;
import com.Digipaywallet.DigiPayWalletRevamp.vo.TransactionVO;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@SessionAttributes("userVO")
@RequestMapping(value = "/payments")
public class PaymentsController {
		@Autowired
	    private PaymentsService paymentsService;
		
		@Autowired
	    private TransactionHistoryService transactionHistoryService;
		
	    
	    @PostMapping(value = "/make/payment")
	    public Map<String, Object> makePayment(@RequestBody PaymentsVO paymentsVO,@RequestAttribute("userId") Long id){
	    	System.out.println("in make payments");
	        return paymentsService.createPayment(paymentsVO.getSum());
	    }
	    
	    @PostMapping(value = "/complete/payment")
	    public Map<String, Object> completePayment(@RequestBody PaymentsVO paymentsVO,@RequestAttribute("userId") Long id) throws Exception{
	    	paymentsVO.setUserId(String.valueOf(id));
	        return paymentsService.completePayment(paymentsVO);
	    }
	    
	    @PostMapping(value = "/update/balance")
	    public ResponseEntity<?> updateBalance(@RequestAttribute("userId") Long id) throws Exception{
	    	TransactionVO transactionVO = new TransactionVO();
	    	transactionVO.setUserId(String.valueOf(id));
	    	String s = paymentsService.updateBalance(transactionVO);
	        return  ResponseEntity.ok(s);
	    }
	    
	    @PostMapping(value = "/view/passbook")
	    public ResponseEntity<?> viewPassbook(@RequestAttribute("userId") Long id) throws Exception{
	    	TransactionVO transactionVO = new TransactionVO();
	    	transactionVO.setUserId(String.valueOf(id));
	    	List<TransactionVO> transactionVOResult = transactionHistoryService.viewPassbook(transactionVO);
	    	return  ResponseEntity.ok(transactionVOResult);
	    }
	    
	}

