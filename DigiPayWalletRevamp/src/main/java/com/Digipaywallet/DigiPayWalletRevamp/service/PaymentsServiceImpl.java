package com.Digipaywallet.DigiPayWalletRevamp.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Digipaywallet.DigiPayWalletRevamp.dao.SignUpRepository;
import com.Digipaywallet.DigiPayWalletRevamp.entity.GenUsers;
import com.Digipaywallet.DigiPayWalletRevamp.vo.PaymentsVO;
import com.Digipaywallet.DigiPayWalletRevamp.vo.TransactionVO;
import com.paypal.api.payments.Amount;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payer;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.PaymentExecution;
import com.paypal.api.payments.RedirectUrls;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;

@Service
public class PaymentsServiceImpl implements PaymentsService {
	
	@Autowired
	private AddToWalletService addToWalletService;
	
	@Autowired
	private SignUpRepository signUpRepository;
	
	@Autowired
	private TransactionHistoryService transactionHistoryService;
	
	private final String clientId = "Aag2GIkCjNwO747XvbKHf4nUcXoWJgFtpgk1eRh1OwhFAh5aG6ZEmyLtBCy6FlTUbbc08jCRSMVm-Dy_";
	private final String clientSecret = "EBh54BmCsiLiynOt_nrn2Cc8DesW9EHr_mBPu5ZPo_csG6haG1e7EjWrnnxa6_5KYZP6cCs4-fTtr9Kz";
	

	@Override
	public Map<String, Object> createPayment(String sum) {
		    Map<String, Object> response = new HashMap<>();
		    Amount amount = new Amount();
		    amount.setCurrency("USD");
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
		    redirectUrls.setReturnUrl("http://localhost:4200/success");
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
	
	public Map<String, Object> completePayment(PaymentsVO paymentsVO) throws Exception{
	    Map<String, Object> response = new HashMap<>();
	    Payment payment = new Payment();
	    payment.setId(paymentsVO.getPaymentId());
	    
	    PaymentExecution paymentExecution = new PaymentExecution();
	    paymentExecution.setPayerId(paymentsVO.getPayerId());
	    TransactionVO transactionVO = new TransactionVO();
	    try {
	        APIContext context = new APIContext(this.clientId, this.clientSecret, "sandbox");
	        Payment createdPayment = payment.execute(context, paymentExecution);
	        if(createdPayment!=null){
	            response.put("status", "success");
	            response.put("payment", createdPayment);
	            
	            
	            paymentsVO.setPurchasingAmount(String.valueOf(createdPayment.getTransactions().get(0).getAmount().getTotal()));
	            paymentsVO.setMerchantEmailId(String.valueOf(createdPayment.getTransactions().get(0).getPayee().getEmail()));
	            paymentsVO.setMerchantId(String.valueOf(createdPayment.getTransactions().get(0).getPayee().getMerchantId()));
	            paymentsVO.setPaymentStatus(createdPayment.getState());
	            
	            paymentsVO.setTransactionFee(createdPayment.getTransactions().get(0).getRelatedResources().get(0).getSale().getTransactionFee().getValue());
	            paymentsVO.setReceipientName(createdPayment.getTransactions().get(0).getItemList().getShippingAddress().getRecipientName());
	            addToWalletService.addMoney(paymentsVO);
	            
	            
	            transactionVO.setCreditDebit("C");
	            transactionVO.setReceivedFrom(createdPayment.getPayer().getPayerInfo().getFirstName()
	            		+" "+
	            		createdPayment.getPayer().getPayerInfo().getLastName());
	            transactionVO.setPaymentTime(createdPayment.getCreateTime());
	            transactionVO.setPurchasingAmount(String.valueOf(createdPayment.getTransactions().get(0).getAmount().getTotal()));
	            
	            transactionHistoryService.addTransaction(transactionVO);
	            
	            this.updateBalance(transactionVO);
	         
	        }
	    } catch (PayPalRESTException e) {
	        System.err.println(e.getDetails());
	    }
	    return response;
	}

	@Override
	public String updateBalance(TransactionVO transactionVO) throws Exception {
		Double balance = null;
		try {
			GenUsers genUsers = signUpRepository.findByUsersId(Long.parseLong(transactionVO.getUserId()));
			if (genUsers != null) {
				balance = genUsers.getBalance();
				if("C".equals(transactionVO.getCreditDebit())) {
					balance = balance + Double.parseDouble(transactionVO.getPurchasingAmount());
				}
				else if("D".equals(transactionVO.getCreditDebit())) {
					balance = balance - Double.parseDouble(transactionVO.getPurchasingAmount());
				}
				
				genUsers.setBalance(balance);
				signUpRepository.save(genUsers);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return String.valueOf(balance);
	}
	
}
