package com.Digipaywallet.DigiPayWalletRevamp.vo;

public class PaymentsVO extends BaseVO{
 
	private String sum;
	
	private String token;
	
	private String paymentId;
	
	private String payerId;
	
	private String merchantEmailId;
	
	private String merchantId;
	
	private String paymentStatus;
	
	private String purchasingAmount;
	
	private String receipientName;
	
	private String transactionFee;
	
	

	public String getSum() {
		return sum;
	}

	public void setSum(String sum) {
		this.sum = sum;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	public String getPayerId() {
		return payerId;
	}

	public void setPayerId(String payerId) {
		this.payerId = payerId;
	}

	public String getMerchantEmailId() {
		return merchantEmailId;
	}

	public void setMerchantEmailId(String merchantEmailId) {
		this.merchantEmailId = merchantEmailId;
	}

	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getPurchasingAmount() {
		return purchasingAmount;
	}

	public void setPurchasingAmount(String purchasingAmount) {
		this.purchasingAmount = purchasingAmount;
	}

	public String getReceipientName() {
		return receipientName;
	}

	public void setReceipientName(String receipientName) {
		this.receipientName = receipientName;
	}

	public String getTransactionFee() {
		return transactionFee;
	}

	public void setTransactionFee(String transactionFee) {
		this.transactionFee = transactionFee;
	}
}
