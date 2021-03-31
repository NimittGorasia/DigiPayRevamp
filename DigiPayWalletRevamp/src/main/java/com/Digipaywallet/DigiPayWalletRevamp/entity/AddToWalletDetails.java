package com.Digipaywallet.DigiPayWalletRevamp.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


/**
 * The persistent class for the gen_payment_details database table.
 * 
 */
@Entity
@Table(name="add_to_wallet_details")
@NamedQuery(name="AddToWalletDetails.findAll", query="SELECT g FROM AddToWalletDetails g")
public class AddToWalletDetails implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "add_to_wallet_generator")
	@SequenceGenerator(name="add_to_wallet_generator",sequenceName = "gen_payment_details_seq", allocationSize = 1)
	@Column(name="gen_payment_details_id")
	private long genPaymentDetailsId;

	@Column(name="created_on")
	private Date createdOn;

	@Column(name="merchant_email_id")
	private String merchantEmailId;

	@Column(name="merchant_id")
	private String merchantId;

	@Column(name="payer_id")
	private String payerId;

	@Column(name="payment_id")
	private String paymentId;

	@Column(name="payment_status")
	private String paymentStatus;

	@Column(name="purchasing_amount")
	private double purchasingAmount;

	@Column(name="receipient_name")
	private String receipientName;

	@Column(name="transaction_fee")
	private double transactionFee;

	@Column(name="user_id")
	private long userId;

	public AddToWalletDetails() {
	}

	public long getGenPaymentDetailsId() {
		return this.genPaymentDetailsId;
	}

	public void setGenPaymentDetailsId(long genPaymentDetailsId) {
		this.genPaymentDetailsId = genPaymentDetailsId;
	}

	public Date getCreatedOn() {
		return this.createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getMerchantEmailId() {
		return this.merchantEmailId;
	}

	public void setMerchantEmailId(String merchantEmailId) {
		this.merchantEmailId = merchantEmailId;
	}

	public String getMerchantId() {
		return this.merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	public String getPayerId() {
		return this.payerId;
	}

	public void setPayerId(String payerId) {
		this.payerId = payerId;
	}

	public String getPaymentId() {
		return this.paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	public String getPaymentStatus() {
		return this.paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public double getPurchasingAmount() {
		return this.purchasingAmount;
	}

	public void setPurchasingAmount(double purchasingAmount) {
		this.purchasingAmount = purchasingAmount;
	}

	public String getReceipientName() {
		return this.receipientName;
	}

	public void setReceipientName(String receipientName) {
		this.receipientName = receipientName;
	}

	public double getTransactionFee() {
		return this.transactionFee;
	}

	public void setTransactionFee(double transactionFee) {
		this.transactionFee = transactionFee;
	}

	public long getUserId() {
		return this.userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

}