package myspring.di.xml.test;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import junit.framework.Assert;
import myspring.di.xml.Hello;
import myspring.di.xml.Printer;
import myspring.di.xml.StringPrinter;

public class HelloBeanTest {
	@Test
	@Ignore
	public void setterInjection() {
		BeanFactory factory = new GenericXmlApplicationContext("config/springbeans.xml");

		Hello hello = (Hello) factory.getBean("hello_Setter");
		Hello hello2 = factory.getBean("hello_Setter", Hello.class);

		System.out.println(hello == hello2);
		Assert.assertSame(hello, hello2);

		assertEquals("Hello ½ºÇÁ¸µ", hello.sayHello());

		hello.print();

		Printer printer = (Printer) factory.getBean("strPrinter");

		System.out.println(printer.toString());

	}

	@Test
	public void constructorInjection() {
		BeanFactory factory = new GenericXmlApplicationContext("config/springbeans.xml");

		Hello helloC = (Hello) factory.getBean("hello_Constructor");

		helloC.print();

		System.out.println(helloC.sayHello());

		Printer printer = (Printer) factory.getBean("conPrinter");

		System.out.println(printer.toString());
	}
}
