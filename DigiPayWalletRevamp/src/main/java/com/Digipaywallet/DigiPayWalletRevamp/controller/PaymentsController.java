package com.Digipaywallet.DigiPayWalletRevamp.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Digipaywallet.DigiPayWalletRevamp.service.PaymentsService;

@RestController
@RequestMapping(value = "/payments")
public class PaymentsController {
		@Autowired
	    private PaymentsService paymentsService;
	    
	    @PostMapping(value = "/make/payment")
	    public Map<String, Object> makePayment(@RequestParam("sum") String sum){
	        return paymentsService.createPayment(sum);
	    }
	    
	    @PostMapping(value = "/complete/payment")
	    public Map<String, Object> completePayment(HttpServletRequest request){
	        return paymentsService.completePayment(request);
	    }
	}
