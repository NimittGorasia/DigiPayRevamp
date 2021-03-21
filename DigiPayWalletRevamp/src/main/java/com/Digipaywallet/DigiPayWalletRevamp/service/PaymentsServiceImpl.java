package com.Digipaywallet.DigiPayWalletRevamp.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.paypal.api.payments.Amount;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payer;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.PaymentExecution;
import com.paypal.api.payments.RedirectUrls;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;

public class PaymentsServiceImpl implements PaymentsService {
	
	

	@Override
	public Map<String, Object> createPayment(String sum) {
		    Map<String, Object> response = new HashMap<>();
		    Amount amount = new Amount();
		    amount.setCurrency("INR");
		    amount.setTotal(sum);
		    Transaction transaction = new Transaction();
		    transaction.setAmount(amount);
		    List<Transaction> transactions = new ArrayList<>();
		    transactions.add(transaction);

		    Payer payer = new Payer();
		    payer.setPaymentMethod("paypal");

		    Payment payment = new Payment();
		    payment.setIntent("sale");
		    payment.setPayer(payer);
		    payment.setTransactions(transactions);

		    RedirectUrls redirectUrls = new RedirectUrls();
		    redirectUrls.setCancelUrl("http://localhost:4200/cancel");
		    redirectUrls.setReturnUrl("http://localhost:4200/");
		    payment.setRedirectUrls(redirectUrls);
		    Payment createdPayment;
		    try {
		        String redirectUrl = "";
		        APIContext context = new APIContext(clientId, clientSecret, "sandbox");
		        createdPayment = payment.create(context);
		        if(createdPayment!=null){
		            List<Links> links = createdPayment.getLinks();
		            for (Links link:links) {
		                if(link.getRel().equals("approval_url")){
		                    redirectUrl = link.getHref();
		                    break;
		                }
		            }
		            response.put("status", "success");
		            response.put("redirect_url", redirectUrl);
		        }
		    } catch (PayPalRESTException e) {
		        System.out.println("Error happened during payment creation!");
		    }
		    return response;
		}
	
	public Map<String, Object> completePayment(HttpServletRequest req){
	    Map<String, Object> response = new HashMap();
	    Payment payment = new Payment();
	    payment.setId(req.getParameter("paymentId"));

	    PaymentExecution paymentExecution = new PaymentExecution();
	    paymentExecution.setPayerId(req.getParameter("PayerID"));
	    try {
	        APIContext context = new APIContext(clientId, clientSecret, "sandbox");
	        Payment createdPayment = payment.execute(context, paymentExecution);
	        if(createdPayment!=null){
	            response.put("status", "success");
	            response.put("payment", createdPayment);
	        }
	    } catch (PayPalRESTException e) {
	        System.err.println(e.getDetails());
	    }
	    return response;
	}
}
