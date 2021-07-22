package myspring.di.xml.test;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.function.Consumer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import myspring.di.xml.Hello;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:config/spring-beans.xml")
public class HelloSpringTest {
	@Autowired
	@Qualifier("helloC")
	Hello hello2;
	
	@Test
	public void hello() {
		System.out.println(hello2.sayHello());
		assertEquals("Hello 생성자", hello2.sayHello());
		hello2.print();
		
		List<String> names = hello2.getNames();
		
		// Anonymous Inner Class
		names.forEach(new Consumer<String>() {
			@Override
			public void accept(String t) {
				System.out.println(t);
				// TODO Auto-generated method stub
			}
		});
		// Lambda Expression
		names.forEach(name -> System.out.println(name));
		// Method Reference -> 람다식을 심플하게
		names.forEach(System.out::println);		
		
	}
}
