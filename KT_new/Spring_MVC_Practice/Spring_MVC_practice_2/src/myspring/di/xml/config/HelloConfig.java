package myspring.di.xml.config;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import myspring.di.xml.ConsolePrinter;
import myspring.di.xml.Hello;
import myspring.di.xml.Printer;
import myspring.di.xml.StringPrinter;

@Configuration
@PropertySource("classpath:config/values.properties")
public class HelloConfig {
	@Value("${name}")
	String name;

	@Resource(name = "${printer}")
	Printer printer;

	@Bean
	public Hello hello() {
		Hello hello = new Hello();
		hello.setName(name);
		hello.setPrinter(stringPrinter());
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
