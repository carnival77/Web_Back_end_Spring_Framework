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
	HelloBean hello;
	
	@Autowired
	@Qualifier("stringPrinter")
	PrinterBean printer;
	
	@Test @Ignore
	public void 전략2_컨스트럭터() {
		Assert.assertEquals("Hello 생성자어노테이션", hello.sayHello());
		hello.print();
		Assert.assertEquals("Hello 생성자어노테이션", printer.toString());
	}
	
	
	@Test
	public void 전략2_세터() {
		Assert.assertEquals("Hello 전략2어노테이션", hello.sayHello());
		hello.print();
		Assert.assertEquals("Hello 전략2어노테이션", printer.toString());
	}
}
