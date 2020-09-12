package com.bankingsystem.beans;

import java.time.LocalDate;

public class FundTransfer {
	
	private long fromAccount;
	private long toAccount;
	private LocalDate transferedDate;
	private double amount;
	
	public long getFromAccount() {
		return fromAccount;
	}
	public void setFromAccount(long fromAccount) {
		this.fromAccount = fromAccount;
	}
	public long getToAccount() {
		return toAccount;
	}
	public void setToAccount(long toAccount) {
		this.toAccount = toAccount;
	}
	public LocalDate getTransferedDate() {
		return transferedDate;
	}
	public void setTransferedDate(LocalDate transferedDate) {
		this.transferedDate = transferedDate;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}

}
