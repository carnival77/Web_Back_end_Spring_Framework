package myspring.di.xml.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import junit.framework.Assert;
import myspring.di.xml.Hello;
import myspring.di.xml.Printer;
import myspring.di.xml.StringPrinter;

// 52p. 3.5 jUnit 을 사용한 DI 테스트 클래스
// 60p. 전략 (1) XML 설정 단독 사용

public class HelloBeanTest {
	@Test
	public void setterInjection() {
		BeanFactory factory = new GenericXmlApplicationContext("config/springbeans.xml");
		
//		BeanFactory : 
//		스프링의 IoC 를 담당하는 핵심 컨테이너 를 가리킴
//		Bean 을 등록 , 생성 , 조회 , 반환하는 기능을 담당함
//		이 BeanFactory 를 바로 사용하지 않고 이를 확장한
//		ApplicationContext 를 주로 이용함
		
		Hello hello = (Hello) factory.getBean("hello");
		Hello hello2 = factory.getBean("hello", Hello.class);
		
		//Bean : 	
//		스프링이 IoC 방식으로 관리하는 객체 라는 뜻
//		스프링이 직접 생성과 제어를 담당하는 객체를 Bean 이라고 부름

		System.out.println(hello == hello2);
		Assert.assertSame(hello, hello2);

		assertEquals("Hello 스프링", hello.sayHello());

		hello.print();

		Printer printer = factory.getBean("strPrinter", Printer.class);
		System.out.println(printer.getClass().getName());
		System.out.println(printer.toString());

	}
}
