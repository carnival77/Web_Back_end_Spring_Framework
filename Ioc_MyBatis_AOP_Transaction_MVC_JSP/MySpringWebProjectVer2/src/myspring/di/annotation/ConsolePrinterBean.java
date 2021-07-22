package myspring.di.annotation;

import org.springframework.stereotype.Component;

//<bean id="consolePrinterBean" class="StringPrinterBean" />
@Component("consolePrinter")
public class ConsolePrinterBean implements PrinterBean {
	public ConsolePrinterBean() {
		System.out.println(this.getClass().getName() + " called..");
	}
	
	public void print(String message) {
		System.out.println(message);
	}
}
