package myspring.di.xml.test;

import static org.junit.Assert.*;

import org.junit.Before;
//import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import myspring.di.xml.Hello;
import myspring.di.xml.Printer;

public class HelloJunitTest {
	BeanFactory factory;
	
	@Before
	public void init() {
		// 1. Spring Bean Container ����
		factory = new GenericXmlApplicationContext("config/spring-beans.xml");
		// GenericXmlApplicationContext : �����丮�̴�. IOC �����̳� ������ �ϴ� ��ü��.
		
	}
	
	@Test
	public void hello() {
		
		// 2. Container ��ü�� ������ Hello Bean�� ��������
		Hello hello = (Hello) factory.getBean("hello");
		
		Hello hello2 = factory.getBean("hello", Hello.class);
		
		// Bean ��ü�� �ּ� ��. 
		//scope �� singleton�̸� true. ���� �� ��ü �ν��Ͻ��� �������ϱ�.
		//scope �� prototype���� �ϸ�, ���� �� ��ü�� �ƴϹǷ� false.
		System.out.println(hello == hello2);
		
		assertSame(hello, hello2);
		
		//�޼ҵ� ȣ�� ��� �� �� . Hello  �� sayHello �� print�ϴ� ���� �ٸ��Ƿ� false
		assertEquals("Hello ������", hello.sayHello());
		
		hello.print();
		
		// 3. Container ��ü�� ������ StringPrinter Bean ��������
		Printer printer = factory.getBean("strPrinter",Printer.class);
		
		assertEquals("Hello ������", printer.toString());
	}
}
