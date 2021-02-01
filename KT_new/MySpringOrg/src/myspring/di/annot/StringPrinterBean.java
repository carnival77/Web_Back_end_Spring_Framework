package myspring.di.annot;

import org.springframework.stereotype.Component;

@Component("stringPrinter")
//<bean id="stringPrinter" class="xxx.StringPrinterBean" />
public class StringPrinterBean implements PrinterBean {
	public StringPrinterBean() {
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
