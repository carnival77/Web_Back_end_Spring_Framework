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

//���� (3) ������̼� ���� �ܵ� ��� ver3.0)
//Spring JavaConfig ������Ʈ�� XML �� �ƴ� �ڹ� �ڵ带 �̿��ؼ�
//�����̳ʸ� ������ �� �ִ� ����� �����ϴ� ������Ʈ�̴�
//Configuration ������̼ǰ� @Bean ������̼��� �̿��ؼ�
//������ �����̳ʿ� ���ο� �� ��ü�� ������ �� �ִ�
//Spring 3.0���ʹ� ������̼��� �̿��� Bean �� ��� �� Bean ��
//���� ���� ������ �ڹ� �ڵ� ���ο� �ϹǷ� XML �� ���� ������� �ʴ´�

@Configuration
//Ŭ������ @Configuration ������̼��� �����ϴ� ����
//������ IoC �����̳ʰ� �ش� Ŭ������ Bean�� �����ϴ� Ŭ������ ����Ѵٴ� ���� ��Ÿ����
@PropertySource("classpath:config/values.properties")
public class HelloConfig {
	// Bean�� id�� �޼��� �̸��̴�.
	@Value("${name}")
	String name;

	@Resource(name = "${printer}")
	Printer printer;

	@Bean
//	@Bean ������̼��� ���ο� �� ��ü�� ������ ��
//	���Ǹ� @Bean �� ����� �޼����� �̸��� Bean �� �ĺ������� ����Ѵ�
	@Scope(value = "singleton")
//	@Scope(value = "prototype")
	public Hello hello() {
		Hello hello = new Hello();
		hello.setName(name);
//		hello.setName("Java���Ǳ�");
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
