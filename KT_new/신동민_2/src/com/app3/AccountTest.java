package com.app3;

public class AccountTest {
	public static void main(String[] args) {
		Account account;
		account = new Account("441-0290-1203",500000,0.073);
		
		System.out.println(account.toString());
		
		account.deposit(-10.0);
		
	}
}
