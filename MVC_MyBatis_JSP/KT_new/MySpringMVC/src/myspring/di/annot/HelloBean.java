package myspring.di.annot;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//61p. ���� (2) ������̼ǰ� XML ���� ȥ���ؼ� ���

@Component("helloBean")
//Bean���� ���� Ŭ������ Ư���� ������̼� @Component��
//�ο����ָ� �̷� Ŭ������ �ڵ����� ã�Ƽ� Bean ���� ����Ѵ�
//@Component ������̼��� ����� Ŭ������ �ڵ����� ã�Ƽ�
//Bean ���� ��� ���ִ� ����� �� ��ĳ��(Bean scanning) �� ���� �ڵ��ν� Bean ��� ��� �̶�� �Ѵ�

//@Component
//������Ʈ�� ��Ÿ���� �Ϲ����� ���׷��� Ÿ������
//xml���� <bean> �±׿� ������ ������ ��

public class HelloBean {
	// <property name = "name" value="������̼�" />
//	@Value(value = "������̼�")
	@Value("${name}")
	private String name;
//	@Value
//	�ܼ��� ���� ������ �� ���Ǵ� ������̼��̴� .
//	@Value(��Spring��) �� <property .. value=��Spring�� /> �� ������
//	������ �Ѵ�

	// <property name = "printer" ref = "strPrinter"/>
//	@Autowired
//	@Qualifier("stringPrinter")
	@Resource(name = "${printer}")
	private PrinterBean printer;

	public HelloBean() {
		System.out.println("Hello Default Constructor called..");
	}

//	@Autowired
//	public HelloBean(
//			@Value("�����ھ�����̼�") String name, 
//			@Qualifier("stringPrinter") PrinterBean printer) {

	public HelloBean(String name, PrinterBean printer) {
		this.name = name;
		this.printer = printer;
	}

	public void setName(String name) {
		System.out.println("Hello setName() called.." + name);
		this.name = name;
	}

	public void setPrinter(PrinterBean printer) {
		System.out.println("Hello setPrinter called.." + printer.getClass().getName());
		this.printer = printer;
	}

	public String sayHello() {
		return "Hello " + this.name;
	}

	public void print() {
		this.printer.print(sayHello());
	}

}
