package myspring.di.annot;

import org.springframework.stereotype.Component;

@Component("consolePrinter")
public class ConsolePrinterBean implements PrinterBean {
	public ConsolePrinterBean() {
		System.out.println("ConsolePrinter Default Constructor");
	}
	
	@Override
	public void print(String message) {
		System.out.println(message);
	}

}
