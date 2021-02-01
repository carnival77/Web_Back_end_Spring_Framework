package myspring.di.xml.config;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import myspring.di.xml.ConsolePrinter;
import myspring.di.xml.Hello;
import myspring.di.xml.Printer;
import myspring.di.xml.StringPrinter;

@Configuration
@PropertySource("classpath:config/values.properties")
public class HelloConfig {
	// Bean의 id는 메서드 이름이다.
	@Value("${name}")
	String name;

	@Resource(name = "${printer}")
	Printer printer;

	@Bean
	@Scope(value = "singleton")
//	@Scope(value = "prototype")
	public Hello hello() {
		Hello hello = new Hello();
		hello.setName(name);
//		hello.setName("Java컨피그");
		hello.setPrinter(printer);
//		hello.setPrinter(stringPrinter());
		return hello;
	}

	@Bean
	public Printer stringPrinter() {
		Printer printer = new StringPrinter();
		return printer;
	}

	@Bean
	public Printer consolePrinter() {
		Printer printer = new ConsolePrinter();
		return printer;
	}

}
