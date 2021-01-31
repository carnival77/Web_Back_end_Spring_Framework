package com.mypractice.first;

public class conPrinter implements Printer {

	public conPrinter() {
		System.out.println("conPrinter Default Constructor");
	}

	@Override
	public void print(String message) {
		System.out.println(message);
	}

}
