package myspring.di.annotation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

//전략 3.
//- XML 이 아닌 자바 코드를 이용해서 컨테이너를 설정함
//- Configuration 어노테이션과 @Bean 어노테이션을 이용해서 스프링 컨테이너에 새로운 빈 객체를 제공할 수 있다
// 2. @Configuration 과 ComponentScan (p.73)
@Configuration
@ComponentScan(basePackages = {"myspring.di.annotation"})
// xml 의 <context:component-scan base-package="myspring.di.annotation"></context:component-scan> 대체
@PropertySource("classpath:config/values.properties")
// xml 의 	<!-- properties file 정보 설정 --> <context:property-placeholder location="config/values.properties"/>
public class HelloBeanConfig {

}
