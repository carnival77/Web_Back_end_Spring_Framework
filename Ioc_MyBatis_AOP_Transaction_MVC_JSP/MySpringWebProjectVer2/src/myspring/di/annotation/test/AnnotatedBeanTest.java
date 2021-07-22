package myspring.di.annotation.test;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import myspring.di.annotation.HelloBean;
import myspring.di.annotation.PrinterBean;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/spring-beans.xml")
public class AnnotatedBeanTest {
	@Autowired
	HelloBean bean;
	
	@Autowired
	@Qualifier("stringPrinter")
	PrinterBean printer;
	
	@Test
	public void hellobean() {
		System.out.println(bean.sayHello());
		assertEquals("Hello 어노테이션", bean.sayHello());
		bean.print();
		
		assertEquals("Hello 어노테이션", printer.toString());
		
	}
}
