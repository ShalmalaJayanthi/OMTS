package com.cg.omts.dto;

public class Transaction {
	private int transactionId;
	private int accountNumber;
	private int totalAmount;
	
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Transaction(int transactionId, int accountNumber, int totalAmount) {
		super();
		this.transactionId = transactionId;
		this.accountNumber = accountNumber;
		this.totalAmount = totalAmount;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", accountNumber=" + accountNumber + ", totalAmount="
				+ totalAmount + "]";
	}
	
}
