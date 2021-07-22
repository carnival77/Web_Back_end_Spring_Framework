package myspring.di.xml.config.test;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import myspring.di.xml.Hello;
import myspring.di.xml.Printer;
import myspring.di.xml.config.HelloConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = HelloConfig.class, loader = AnnotationConfigContextLoader.class)
public class HelloConfigTest {
	@Autowired
	Hello hello;

	@Autowired
	@Qualifier("hello")
	Hello hello2;

	@Autowired
	@Qualifier("stringPrinter")
	Printer printer;
	
	@Test
	public void consoleConfig() {
		System.out.println(hello.sayHello());
		hello.print();
	}
	
	@Test @Ignore
	public void config() {
		System.out.println(hello == hello2);
		
		System.out.println(hello.sayHello());
		hello.print();
		System.out.println(printer.toString());
	}
}
