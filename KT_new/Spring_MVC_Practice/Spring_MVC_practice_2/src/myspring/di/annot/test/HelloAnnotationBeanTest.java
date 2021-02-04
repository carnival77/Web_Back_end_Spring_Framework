package myspring.di.annot.test;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import myspring.di.annot.HelloBean;
import myspring.di.annot.PrinterBean;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/springbeans.xml")
public class HelloAnnotationBeanTest {
	@Autowired
//	@Qualifier("helloBean")
	HelloBean hello;

	@Autowired
	@Qualifier("consolePrinter")
	PrinterBean printer;

	@Test
	public void DI2() {
		hello.print(); // printer = StringPrinter
		System.out.println(printer.getClass()); // consolePrinter
		System.out.println(hello.sayHello());
	}

}
