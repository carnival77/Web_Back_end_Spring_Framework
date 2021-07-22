package myspring.di.xml;

import java.util.Map;

public class Hello {
	private String name;
	private Printer printer;
	private Map<Integer, String> myMaps;
	
	public Hello() {
		System.out.println("Hello Default Constructor called..");
	}
	
	public Hello(String name, Printer printer) {
		this.name = name;
		this.printer = printer;
	}
	
	public void setName(String name) {
		System.out.println("Hello setName() called.." + name);
		this.name = name;
	}
	
	public void setPrinter(Printer printer) {
		System.out.println("Hello setPrinter called.. " + printer.getClass().getName());
		this.printer = printer;
	}
	
	public String sayHello() {
		return "Hello " + this.name;
	}
	
	public void print() {
		this.printer.print(sayHello());
	}
	
	public Map<Integer, String> getMyMaps() {
		return myMaps;
	}
	
	public void setMyMaps(Map<Integer, String> myMaps) {
		this.myMaps = myMaps;
	}
}
