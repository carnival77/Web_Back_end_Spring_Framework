package myspring.di.annot;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("helloBean")
public class HelloBean {

	@Value("${name}")
	private String name;
	@Resource(name = "${printer}")
	private PrinterBean printer;
	private Map<Integer, String> myMaps;
	private List<String> myList;

	public List<String> getMyList() {
		return myList;
	}

	public void setMyList(List<String> myList) {
		this.myList = myList;
	}

	public HelloBean() {
		System.out.println("Hello Default Constructor called..");
	}

	public HelloBean(String name, PrinterBean printer) {
		this.name = name;
		this.printer = printer;
	}

	public void setName(String name) {
		System.out.println("Hello setName() called.." + name);
		this.name = name;
	}

	public void setPrinter(PrinterBean printer) {
		System.out.println("Hello setPrinter called.." + printer.getClass().getName());
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
