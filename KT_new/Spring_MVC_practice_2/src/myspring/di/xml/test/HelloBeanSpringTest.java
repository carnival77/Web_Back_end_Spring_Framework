package myspring.di.xml.test;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import myspring.di.xml.Hello;
import myspring.di.xml.Printer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/springbeans.xml")
public class HelloBeanSpringTest {

	@Autowired
	@Qualifier("hello_Setter")
	Hello hello;

	@Autowired
	@Qualifier("conPrinter")
	Printer printer;

	@Resource(name = "hello_Constructor")
	Hello hello2;

	@Test
	public void setterInjection() {
		System.out.println(hello.sayHello());
		Assert.assertEquals("Hello ½ºÇÁ¸µ", hello.sayHello());

		System.out.println(printer.toString());
		printer.print("this is conPrinter");

		Map<Integer, String> myMaps = hello.getMyMaps();
		for (Map.Entry<Integer, String> entry : myMaps.entrySet()) {
			System.out.println(entry.getKey() + " = " + entry.getValue());
		}

		List<String> myList = hello.getMyList();
		for (String string : myList) {
			System.out.println(string.toString());
		}

		hello2.print();

	}

}
