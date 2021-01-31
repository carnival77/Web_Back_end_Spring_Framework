package com.mypractice.first;

public class strPrinter implements Printer {
	StringBuilder builder = new StringBuilder();

	public strPrinter() {
		System.out.println("strPrinter Default Constructor");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void print(String message) {
		// TODO Auto-generated method stub
		this.builder.append(message);
	}

	@Override
	public String toString() {
		return this.builder.toString();
	}

}
