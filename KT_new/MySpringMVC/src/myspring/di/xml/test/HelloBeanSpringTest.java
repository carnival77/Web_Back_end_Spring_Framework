package myspring.di.xml.test;

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
	// BeanFactory factory = new
	// GenericXmlApplicationContext("config/springbeans.xml");
	@Autowired
	Hello hello;

	@Autowired
	@Qualifier("strPrinter") // 정확히 어떤 printer를 원하는 지 표시
	Printer printer;
	
	@Resource(name="helloC")
	Hello hello2;
	
	@Test
	public void constructorInjection() {
		hello2.print();
	}

	@Test
	public void setterInjection() {
		Assert.assertEquals("Hello 스프링", hello.sayHello());
		hello.print();
		Assert.assertEquals("Hello 스프링", printer.toString());
		
		Map<Integer, String> myMaps = hello.getMyMaps();
		for (Map.Entry<Integer,String> entry : myMaps.entrySet()) {
			System.out.println(entry.getKey() + " = " + entry.getValue());
		}
		

	}

}
