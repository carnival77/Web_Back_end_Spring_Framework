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

// 58p. 3.5 Spring Test 를 사용한 DI 테스트 클래스
// 60p. 전략 (1) XML 설정 단독 사용

@RunWith(SpringJUnit4ClassRunner.class)
//RunWith 는 jUnit 프레임워크의 테스트 실행방법을 확장할 때 사용하는 어노테이션이다 .
//SpringJUnit4ClassRunner 라는 클래스를 지정해주면 jUnit 이 테스트를
//진행하는 중에 ApplicationContext 를 만들고 관리하는 작업을 진행해 준다
//RunWith 어노테이션은 각각의 테스트 별로 객체가 생성되더라도
//싱글톤 ( 의 ApplicationContext 를 보장한다

@ContextConfiguration(locations = "classpath:config/springbeans.xml")
//스프링 빈 (Bean) 설정 파일의 위치를 지정할 때 사용되는 어노테이션이다
public class HelloBeanSpringTest {
	// BeanFactory factory = new BeanFactory();
	// GenericXmlApplicationContext("config/springbeans.xml");
//	@Autowired 를 사용하면 
//	해당 변수에 자동으로 빈을 매핑 해준다 .
//	스프링 빈 (Bean) 설정 파일을 읽기 위해 굳이
//	GenericXmlApplicationContext 를 사용할 필요가 없다.

//	@Autowired , @Resource 어노테이션은 의존하는 객체를
//	자동으로 주입해 주는 어노테이션 이다 .
//	@Autowired 는 타입으로 , @Resource 는 이름으로 연결한다는
//	점이 다르다

	@Autowired
	Hello hello;
//	@Autowired
//	정밀한 의존관계 주입 (Dependency 이 필요한 경우에 유용하다)
//	Autowired 는 변수 , setter 메서드 , 생성자 , 일반메서드에 적용 가능하다
//	의존하는 객체를 주입할 때 주로 Type 을 이용하게 된다
//	Autowired 는 <property>, <constructor arg > 태그와 동일한 역할을 한다

	@Autowired
	@Qualifier("strPrinter") // 정확히 어떤 printer를 원하는 지 표시
	Printer printer;
//	@Qualifier
//	@Qualifier는 Autowired 어노테이션과 같이 사용된다.
//	Autowired 는 타입으로 찾아서 주입하므로 , 동일한 타입의 Bean 객체가 여러 개 존재할 때
//	특정 Bean 을 찾기 위해서는 @Qualifier 를 같이 사용해야 한다

	@Resource(name = "helloC")
	Hello hello2;
//	@Resource
//	어플리케이션에서 필요로 하는 자원을 자동 연결할 때 사용된다
//	@Resource는 변수 , setter 메서드에 적용 가능하다
//	의존하는 객체를 주입할 때 주로 Name 을 이용하게 된다

	@Test
	public void constructorInjection() {
		hello2.print();
	}

	@Test
	public void setterInjection() {
		Assert.assertEquals("Hello 스프링", hello.sayHello());
		hello.print();
//		Assert.assertEquals("Hello 스프링", printer.toString());

		Map<Integer, String> myMaps = hello.getMyMaps();
		for (Map.Entry<Integer, String> entry : myMaps.entrySet()) {
			System.out.println(entry.getKey() + " = " + entry.getValue());
		}

	}

}
