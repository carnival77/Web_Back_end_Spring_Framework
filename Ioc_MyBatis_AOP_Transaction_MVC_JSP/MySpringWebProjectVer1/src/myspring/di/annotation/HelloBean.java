package myspring.di.annotation;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("helloBean")
public class HelloBean {
//	@Value("어노테이션")
	// 값을 직접 선언하는 것 대신, 동적으로 config/values.properties 에 값을 넣고 ${} 로 불러올 수 있다.
	@Value("${myName}")
	String name;

	// @Autowired 는 @Value 처럼 동적할당이 안 된다.
	// @Resource 는 된다.
//	@Autowired
//	@Qualifier("stringPrinter")
	@Resource(name = "${myPrinter}")
	PrinterBean printer;

	List<String> names;

	public HelloBean() {
		System.out.println(this.getClass().getName() + " called.. ");
	}

	// 위에 초기 선언하는 대신, 바로 생성자의 변수에 직접적으로 선언해도 된다.
//	@Autowired 
//	public HelloBean(@Value("어노테이션") String name, @Qualifier("stringPrinter") PrinterBean printer) {
	public HelloBean(String name, PrinterBean printer) {
		System.out.println(this.getClass().getName() + " 중복 정의된 생성자 called...");
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
