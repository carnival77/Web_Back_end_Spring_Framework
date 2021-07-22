package myspring.di.xml.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import myspring.di.xml.ConsolePrinter;
import myspring.di.xml.Hello;
import myspring.di.xml.Printer;
import myspring.di.xml.StringPrinter;

//전략 3. 1. @Configuration 과 @Bean (p.72)
@Configuration
@PropertySource("classpath:config/values.properties")
public class HelloConfig {
	
	@Autowired
	Environment env;
	
	// 빈 설정
	// xml 의 <bean id = ...>
	@Bean
	public Hello hello() {
		Hello hello = new Hello();
		hello.setName(env.getProperty("myName"));
		hello.setPrinter(stringPrinter());
		return hello;
	}
	
	@Bean
	public Printer stringPrinter() {
		return new StringPrinter();
	}
	
	@Bean
	public Printer consolePrinter() {
		return new ConsolePrinter();
	}
	
	
	
}
