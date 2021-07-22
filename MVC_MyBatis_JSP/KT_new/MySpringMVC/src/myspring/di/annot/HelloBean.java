package myspring.di.annot;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//61p. 전략 (2) 어노테이션과 XML 설정 혼용해서 사용

@Component("helloBean")
//Bean으로 사용될 클래스에 특별한 어노테이션 @Component을
//부여해주면 이런 클래스를 자동으로 찾아서 Bean 으로 등록한다
//@Component 어노테이션이 선언된 클래스를 자동으로 찾아서
//Bean 으로 등록 해주는 방식을 빈 스캐닝(Bean scanning) 을 통한 자동인식 Bean 등록 기능 이라고 한다

//@Component
//컴포넌트를 나타내는 일반적인 스테레오 타입으로
//xml에서 <bean> 태그와 동일한 역할을 함

public class HelloBean {
	// <property name = "name" value="어노테이션" />
//	@Value(value = "어노테이션")
	@Value("${name}")
	private String name;
//	@Value
//	단순한 값을 주입할 때 사용되는 어노테이션이다 .
//	@Value(“Spring”) 은 <property .. value=“Spring” /> 와 동일한
//	역할을 한다

	// <property name = "printer" ref = "strPrinter"/>
//	@Autowired
//	@Qualifier("stringPrinter")
	@Resource(name = "${printer}")
	private PrinterBean printer;

	public HelloBean() {
		System.out.println("Hello Default Constructor called..");
	}

//	@Autowired
//	public HelloBean(
//			@Value("생성자어노테이션") String name, 
//			@Qualifier("stringPrinter") PrinterBean printer) {

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

}
