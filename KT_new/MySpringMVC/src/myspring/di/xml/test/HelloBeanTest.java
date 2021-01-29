package myspring.di.xml.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import junit.framework.Assert;
import myspring.di.xml.Hello;
import myspring.di.xml.Printer;
import myspring.di.xml.StringPrinter;

public class HelloBeanTest {
	@Test
	public void setterInjection() {
		BeanFactory factory = new GenericXmlApplicationContext("config/springbeans.xml");
		Hello hello = (Hello) factory.getBean("hello");
		Hello hello2 = factory.getBean("hello", Hello.class);

		System.out.println(hello == hello2);
		Assert.assertSame(hello, hello2);

		assertEquals("Hello ½ºÇÁ¸µ", hello.sayHello());

		hello.print();

		Printer printer = factory.getBean("strPrinter", Printer.class);
		System.out.println(printer.getClass().getName());
		System.out.println(printer.toString());

	}
}
