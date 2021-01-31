package com.mypractice.first;

public class Hello {
	private String name;
	private Printer printer;

	public Hello() {
		System.out.println("Hello Default Constructor called..");
	}

	public Hello(String name, Printer printer) {
		super();
		this.name = name;
		this.printer = printer;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrinter(Printer printer) {
		this.printer = printer;
	}

	public String sayHello() {
		return "Hello +" + this.name;
	}

	public void print() {
		this.printer.print(sayHello());
	}

}