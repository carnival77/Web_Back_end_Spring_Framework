package myspring.di.annotation;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("helloBean")
public class HelloBean {
//	@Value("������̼�")
	// ���� ���� �����ϴ� �� ���, �������� config/values.properties �� ���� �ְ� ${} �� �ҷ��� �� �ִ�.
	@Value("${myName}")
	String name;

	// @Autowired �� @Value ó�� �����Ҵ��� �� �ȴ�.
	// @Resource �� �ȴ�.
//	@Autowired
//	@Qualifier("stringPrinter")
	@Resource(name = "${myPrinter}")
	PrinterBean printer;

	List<String> names;

	public HelloBean() {
		System.out.println(this.getClass().getName() + " called.. ");
	}

	// ���� �ʱ� �����ϴ� ���, �ٷ� �������� ������ ���������� �����ص� �ȴ�.
//	@Autowired 
//	public HelloBean(@Value("������̼�") String name, @Qualifier("stringPrinter") PrinterBean printer) {
	public HelloBean(String name, PrinterBean printer) {
		System.out.println(this.getClass().getName() + " �ߺ� ���ǵ� ������ called...");
		this.name = name;
		this.printer = printer;
	}

	public List<String> getNames() {
		return this.names;
	}

	public void setNames(List<String> list) {
		this.names = list;
	}

	public String sayHello() {
		return "Hello " + name;
	}

	public void print() {
		this.printer.print(sayHello());
	}

}
