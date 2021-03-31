package com.Digipaywallet.DigiPayWalletRevamp.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;



/**
 * The persistent class for the transaction_history database table.
 * 
 */
@Entity
@Table(name="transaction_history")
@NamedQuery(name="TransactionHistory.findAll", query="SELECT t FROM TransactionHistory t")
public class TransactionHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transaction_generator")
	@SequenceGenerator(name="transaction_generator", sequenceName = "transaction_history_seq", allocationSize = 1)
	@Column(name="transaction_history_id")
	private long transactionHistoryId;

	private double amount;

	@Column(name="created_on")
	private Date createdOn;

	@Column(name="credit_debit")
	private String creditDebit;

	@Column(name="paid_to")
	private String paidTo;

	@Column(name="payment_time")
	private Date paymentTime;

	@Column(name="received_from")
	private String receivedFrom;

	private String status;
	
	@Column(name="user_id")
	private long userId;

	public TransactionHistory() {
	}

	public long getTransactionHistoryId() {
		return this.transactionHistoryId;
	}

	public void setTransactionHistoryId(long transactionHistoryId) {
		this.transactionHistoryId = transactionHistoryId;
	}

	public double getAmount() {
		return this.amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getCreatedOn() {
		return this.createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getCreditDebit() {
		return this.creditDebit;
	}

	public void setCreditDebit(String creditDebit) {
		this.creditDebit = creditDebit;
	}

	public String getPaidTo() {
		return this.paidTo;
	}

	public void setPaidTo(String paidTo) {
		this.paidTo = paidTo;
	}

	public Date getPaymentTime() {
		return this.paymentTime;
	}

	public void setPaymentTime(Date paymentTime) {
		this.paymentTime = paymentTime;
	}

	public String getReceivedFrom() {
		return this.receivedFrom;
	}

	public void setReceivedFrom(String receivedFrom) {
		this.receivedFrom = receivedFrom;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public long getUserId() {
		return this.userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

}