package com.app3;

public class Account {
	private String account;
	private double balance;
	private double interestRate;
	
//	AccountException exception = new AccountException();

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
		return result;
	}

	@Override
	public String toString() {
		return "Account [account=" + account + ", balance=" + balance + ", interestRate=" + interestRate + "]";
	}

	public void deposit (double money) throws AccountException{
//		if(balance<money) {
//			throw new AccountException("ÀÜ¾×ÀÌ ºÎÁ·");
//		}
			balance+= money;
//		} catch (Exception e) {
//			e.getMessage();
//			AccountException(e);
//			// TODO: handle exception
//		}
	}

	public void withdraw (double money) throws AccountException {
		if(balance<money) {
			throw new AccountException("ÀÜ¾×ÀÌ ºÎÁ·");
		}
			balance-=money;
			
		
	}

	private void AccountException(Exception e) {
		// TODO Auto-generated method stub
		
	}

}
