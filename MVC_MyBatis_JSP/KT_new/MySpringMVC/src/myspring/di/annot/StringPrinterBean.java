package myspring.di.annot;

import org.springframework.stereotype.Component;

@Component("stringPrinter")
//<bean id="stringPrinter" class="xxx.StringPrinterBean" />
public class StringPrinterBean implements PrinterBean {
	StringBuilder builder = new StringBuilder();

	public StringPrinterBean() {
		System.out.println("StringPrinter Default Constructor");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void print(String message) {
		this.builder.append(message);

	}

	public String tostrString() {
		return this.builder.toString();
	}

}
