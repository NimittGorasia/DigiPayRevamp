package com.Digipaywallet.DigiPayWalletRevamp.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Digipaywallet.DigiPayWalletRevamp.service.PaymentsService;
import com.Digipaywallet.DigiPayWalletRevamp.vo.PaymentsVO;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/payments")
public class PaymentsController {
		@Autowired
	    private PaymentsService paymentsService;
	    
	    @PostMapping(value = "/make/payment")
	    public Map<String, Object> makePayment(@RequestBody PaymentsVO paymentsVO){
//	    	System.out.println("sum:"+sum);
	    	System.out.println("in make payments");
	        return paymentsService.createPayment(paymentsVO.getSum());
	    }
	    
	    @PostMapping(value = "/complete/payment")
	    public Map<String, Object> completePayment(@RequestBody PaymentsVO paymentsVO){
	        return paymentsService.completePayment(paymentsVO);
	    }
	}
