package myspring.di.xml;

public class StringPrinter implements Printer {
	StringBuilder builder = new StringBuilder();

	public StringPrinter() {
		System.out.println("StringPrinter Default Constructor");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void print(String message) {
		this.builder.append(message);

	}

	public String toString() {
		return this.builder.toString();
	}

}
