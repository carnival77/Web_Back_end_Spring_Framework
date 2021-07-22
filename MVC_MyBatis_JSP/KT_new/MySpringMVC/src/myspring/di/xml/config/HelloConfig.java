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

//전략 (3) 어노테이션 설정 단독 사용 ver3.0)
//Spring JavaConfig 프로젝트는 XML 이 아닌 자바 코드를 이용해서
//컨테이너를 설정할 수 있는 기능을 제공하는 프로젝트이다
//Configuration 어노테이션과 @Bean 어노테이션을 이용해서
//스프링 컨테이너에 새로운 빈 객체를 제공할 수 있다
//Spring 3.0부터는 어노테이션을 이용한 Bean 의 등록 및 Bean 들
//간의 연결 설정을 자바 코드 내부에 하므로 XML 을 전혀 사용하지 않는다

@Configuration
//클래스에 @Configuration 어노테이션을 선언하는 것은
//스프링 IoC 컨테이너가 해당 클래스를 Bean을 설정하는 클래스로 사용한다는 것을 나타낸다
@PropertySource("classpath:config/values.properties")
public class HelloConfig {
	// Bean의 id는 메서드 이름이다.
	@Value("${name}")
	String name;

	@Resource(name = "${printer}")
	Printer printer;

	@Bean
//	@Bean 어노테이션은 새로운 빈 객체를 제공할 때
//	사용되며 @Bean 이 적용된 메서드의 이름을 Bean 의 식별값으로 사용한다
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
