package com.Digipaywallet.DigiPayWalletRevamp.vo;

public class TransactionVO extends BaseVO{
	
	private String creditDebit;
	
	private String paidTo;
	
	private String paymentTime;

	private String receivedFrom;

	private String transactionStatus;
	
	private String purchasingAmount;
	
	public String getCreditDebit() {
		return creditDebit;
	}

	public void setCreditDebit(String creditDebit) {
		this.creditDebit = creditDebit;
	}

	public String getPaidTo() {
		return paidTo;
	}

	public void setPaidTo(String paidTo) {
		this.paidTo = paidTo;
	}

	public String getPaymentTime() {
		return paymentTime;
	}

	public void setPaymentTime(String paymentTime) {
		this.paymentTime = paymentTime;
	}

	public String getReceivedFrom() {
		return receivedFrom;
	}

	public void setReceivedFrom(String receivedFrom) {
		this.receivedFrom = receivedFrom;
	}

	public String getTransactionStatus() {
		return transactionStatus;
	}

	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	public String getPurchasingAmount() {
		return purchasingAmount;
	}

	public void setPurchasingAmount(String purchasingAmount) {
		this.purchasingAmount = purchasingAmount;
	}

}
