package com.mypractice.first;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloBeanTest {
	@Test
	public void setterInjection() {
		BeanFactory factory = new GenericXmlApplicationContext("./src\\main\\java\\config\\springbeans.xml");
		Hello hello = (Hello) factory.getBean("hello");
		Hello hello2 = factory.getBean("hello", Hello.class);
		
		System.out.println(hello==hello2);
		
		Assert.assertSame(hello, hello2);
		
		
		
		
	}

}
