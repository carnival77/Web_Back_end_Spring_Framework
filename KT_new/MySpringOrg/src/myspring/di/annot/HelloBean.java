package myspring.di.annot;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("helloBean")
public class HelloBean {
	//<property name="name" value="어노테이션" />
	@Value("${name}")
	private String name;
	
	//<property name="printer" ref="stringPrinter" />
//	@Autowired
//	@Qualifier("stringPrinter")
	@Resource(name="${printer}")
	private PrinterBean printer;
	
	public HelloBean() {
		System.out.println("Hello Default Constructor called..");
	}

//	@Autowired
//	public HelloBean(@Value("생성자어노테이션") String name, 
//					 @Qualifier("stringPrinter") PrinterBean printer) {
	public HelloBean(String name, PrinterBean printer) {
		this.name = name;
		this.printer = printer;
	}
	
	public void setName(String name) {
		System.out.println("Hello setName() called.." + name);
		this.name = name;
	}
	
	public void setPrinter(PrinterBean printer) {
		System.out.println("Hello setPrinter called.. " + printer.getClass().getName());
		this.printer = printer;
	}
	
	public String sayHello() {
		return "Hello " + this.name;
	}
	
	public void print() {
		this.printer.print(sayHello());
	}
	
}
