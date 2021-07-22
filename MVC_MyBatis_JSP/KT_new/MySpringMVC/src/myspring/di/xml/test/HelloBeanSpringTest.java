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

// 58p. 3.5 Spring Test �� ����� DI �׽�Ʈ Ŭ����
// 60p. ���� (1) XML ���� �ܵ� ���

@RunWith(SpringJUnit4ClassRunner.class)
//RunWith �� jUnit �����ӿ�ũ�� �׽�Ʈ �������� Ȯ���� �� ����ϴ� ������̼��̴� .
//SpringJUnit4ClassRunner ��� Ŭ������ �������ָ� jUnit �� �׽�Ʈ��
//�����ϴ� �߿� ApplicationContext �� ����� �����ϴ� �۾��� ������ �ش�
//RunWith ������̼��� ������ �׽�Ʈ ���� ��ü�� �����Ǵ���
//�̱��� ( �� ApplicationContext �� �����Ѵ�

@ContextConfiguration(locations = "classpath:config/springbeans.xml")
//������ �� (Bean) ���� ������ ��ġ�� ������ �� ���Ǵ� ������̼��̴�
public class HelloBeanSpringTest {
	// BeanFactory factory = new BeanFactory();
	// GenericXmlApplicationContext("config/springbeans.xml");
//	@Autowired �� ����ϸ� 
//	�ش� ������ �ڵ����� ���� ���� ���ش� .
//	������ �� (Bean) ���� ������ �б� ���� ����
//	GenericXmlApplicationContext �� ����� �ʿ䰡 ����.

//	@Autowired , @Resource ������̼��� �����ϴ� ��ü��
//	�ڵ����� ������ �ִ� ������̼� �̴� .
//	@Autowired �� Ÿ������ , @Resource �� �̸����� �����Ѵٴ�
//	���� �ٸ���

	@Autowired
	Hello hello;
//	@Autowired
//	������ �������� ���� (Dependency �� �ʿ��� ��쿡 �����ϴ�)
//	Autowired �� ���� , setter �޼��� , ������ , �Ϲݸ޼��忡 ���� �����ϴ�
//	�����ϴ� ��ü�� ������ �� �ַ� Type �� �̿��ϰ� �ȴ�
//	Autowired �� <property>, <constructor arg > �±׿� ������ ������ �Ѵ�

	@Autowired
	@Qualifier("strPrinter") // ��Ȯ�� � printer�� ���ϴ� �� ǥ��
	Printer printer;
//	@Qualifier
//	@Qualifier�� Autowired ������̼ǰ� ���� ���ȴ�.
//	Autowired �� Ÿ������ ã�Ƽ� �����ϹǷ� , ������ Ÿ���� Bean ��ü�� ���� �� ������ ��
//	Ư�� Bean �� ã�� ���ؼ��� @Qualifier �� ���� ����ؾ� �Ѵ�

	@Resource(name = "helloC")
	Hello hello2;
//	@Resource
//	���ø����̼ǿ��� �ʿ�� �ϴ� �ڿ��� �ڵ� ������ �� ���ȴ�
//	@Resource�� ���� , setter �޼��忡 ���� �����ϴ�
//	�����ϴ� ��ü�� ������ �� �ַ� Name �� �̿��ϰ� �ȴ�

	@Test
	public void constructorInjection() {
		hello2.print();
	}

	@Test
	public void setterInjection() {
		Assert.assertEquals("Hello ������", hello.sayHello());
		hello.print();
//		Assert.assertEquals("Hello ������", printer.toString());

		Map<Integer, String> myMaps = hello.getMyMaps();
		for (Map.Entry<Integer, String> entry : myMaps.entrySet()) {
			System.out.println(entry.getKey() + " = " + entry.getValue());
		}

	}

}
