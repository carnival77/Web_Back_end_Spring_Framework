package myspring.di.xml.test;

import static org.junit.Assert.*;

import org.junit.Before;
//import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import myspring.di.xml.Hello;
import myspring.di.xml.Printer;

public class HelloJunitTest {
	BeanFactory factory;
	
	@Before
	public void init() {
		// 1. Spring Bean Container 생성
		factory = new GenericXmlApplicationContext("config/spring-beans.xml");
		// GenericXmlApplicationContext : 빈팩토리이다. IOC 컨테이너 역할을 하는 객체다.
		
	}
	
	@Test
	public void hello() {
		
		// 2. Container 객체가 생성한 Hello Bean을 가져오기
		Hello hello = (Hello) factory.getBean("hello");
		
		Hello hello2 = factory.getBean("hello", Hello.class);
		
		// Bean 객체의 주소 비교. 
		//scope 가 singleton이면 true. 같은 빈 객체 인스턴스를 가져오니까.
		//scope 를 prototype으로 하면, 같은 빈 객체가 아니므로 false.
		System.out.println(hello == hello2);
		
		assertSame(hello, hello2);
		
		//메소드 호출 결과 값 비교 . Hello  의 sayHello 와 print하는 값이 다르므로 false
		assertEquals("Hello 스프링", hello.sayHello());
		
		hello.print();
		
		// 3. Container 객체가 생성한 StringPrinter Bean 가져오기
		Printer printer = factory.getBean("strPrinter",Printer.class);
		
		assertEquals("Hello 스프링", printer.toString());
	}
}
