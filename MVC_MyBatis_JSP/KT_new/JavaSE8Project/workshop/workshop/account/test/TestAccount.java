package workshop.account.test;

import workshop.account.entity.Account;
import workshop.account.exception.InvalidBalanceException;

public class TestAccount {

	public static void main(String[] args) {
		Account acnt = new Account("A1100", "221-22-3477", 100000);
		System.out.println(acnt);
		acnt.deposit(10000);
		System.out.println("���� �ܾ� : " + acnt.getBalance());

		try {
			acnt.withdraw(5000);
			System.out.println("���� �ܾ� : " + acnt.getBalance());
			acnt.withdraw(600000);
			System.out.println("���� �ܾ� : " + acnt.getBalance());

		} catch (InvalidBalanceException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}
}
