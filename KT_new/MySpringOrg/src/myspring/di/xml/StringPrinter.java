package myspring.di.xml;

public class StringPrinter implements Printer {
	public StringPrinter() {
		System.out.println("StringPrinter Default Constructor");
	}
	
	StringBuilder builder = new StringBuilder();
	
	@Override
	public void print(String message) {
		this.builder.append(message);
	}
	
	
	public String toString() {
		return this.builder.toString();
	}

}
