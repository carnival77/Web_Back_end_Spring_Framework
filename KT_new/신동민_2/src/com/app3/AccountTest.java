package com.app3;

public class AccountTest {
	public static void main(String[] args) {
		Account account;
		account = new Account("441-0290-1203",500000,0.073);
		
		System.out.println(account.toString());
		
		
		try {
			account.deposit(-10.0);
//			account.withdraw(60000);
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			account.withdraw(600000);
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("¿Ã¿⁄ : "+account.calculateInterest());
		
		
		
	}
}
