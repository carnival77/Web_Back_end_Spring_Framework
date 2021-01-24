package com.app3;

import java.nio.channels.AcceptPendingException;

public class Account {
	private String account;
	private double balance;
	private double interestRate;

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(String account, double balance, double interestRate) {
		super();
		this.account = account;
		this.balance = balance;
		this.interestRate = interestRate;
	}

	public double calculateInterest() {
		double result = 0;
		result = this.balance * this.interestRate;
		return result;
	}

	@Override
	public String toString() {
		return "Account [account=" + account + ", balance=" + balance + ", interestRate=" + interestRate + "]";
	}

	public void deposit(double money) throws AccountException {
		try {
			if (money < 0) {
				throw new AccountException("입금 금액이 0보다 적습니다.");
			} else {
				this.balance += money;
			}
		} catch (AccountException e) {
			System.out.println(e.getMessage());
			// TODO: handle
		}
	}

	public void withdraw(double money) throws AccountException {
		try {
			if (balance < money) {
				throw new AccountException("금액이 0보다 적거나 현재 잔액보다 많습니다.");
			} else {
				this.balance -= money;
			}
		} catch (AccountException e) {
			System.out.println(e.getMessage());
			// TODO: handle
		}
	}

}
