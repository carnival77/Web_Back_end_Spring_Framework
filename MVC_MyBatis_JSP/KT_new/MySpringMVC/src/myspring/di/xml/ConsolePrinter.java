package myspring.di.xml;

public class ConsolePrinter implements Printer {
	public ConsolePrinter() {
		System.out.println("ConsolePrinter Default Constructor");
	}

	@Override
	public void print(String message) {
		System.out.println(message);

	}

}
