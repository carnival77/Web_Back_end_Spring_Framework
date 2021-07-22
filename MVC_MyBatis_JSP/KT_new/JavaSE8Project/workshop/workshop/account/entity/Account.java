package workshop.account.entity;

import java.io.InvalidClassException;

import workshop.account.exception.InvalidBalanceException;

public class Account {
	private String custId;
	private String acctId;
	private int balance;

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(String custId, String acctId, int balance) {
		super();
		this.custId = custId;
		this.acctId = acctId;
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [custId=" + custId + ", acctId=" + acctId + ", balance=" + balance + "]";
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getAcctId() {
		return acctId;
	}

	public void setAcctId(String acctId) {
		this.acctId = acctId;
	}

	public int getBalance() {
		return balance;
	}

//	public void setBalance(int balance) {
//		this.balance = balance;
//	}

	// �Ա�
	public void deposit(int amount) {
		this.balance += amount;
	}

	// ���
	// throws ȣ���� : withdraw �޼ҵ带 ȣ���ڿ��� �ѱ��.
	public void withdraw(int amount) throws InvalidBalanceException {
		if (balance <= amount) {
			// ���ܸ� ������ �߻���Ų��.
			throw new InvalidBalanceException("�ܾ� ����");
		} else {
			this.balance -= amount;
		}
	}

}
