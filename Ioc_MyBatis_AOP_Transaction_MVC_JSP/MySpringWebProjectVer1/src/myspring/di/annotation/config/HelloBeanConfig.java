package myspring.di.annotation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

//���� 3.
//- XML �� �ƴ� �ڹ� �ڵ带 �̿��ؼ� �����̳ʸ� ������
//- Configuration ������̼ǰ� @Bean ������̼��� �̿��ؼ� ������ �����̳ʿ� ���ο� �� ��ü�� ������ �� �ִ�
// 2. @Configuration �� ComponentScan (p.73)
@Configuration
@ComponentScan(basePackages = {"myspring.di.annotation"})
// xml �� <context:component-scan base-package="myspring.di.annotation"></context:component-scan> ��ü
@PropertySource("classpath:config/values.properties")
// xml �� 	<!-- properties file ���� ���� --> <context:property-placeholder location="config/values.properties"/>
public class HelloBeanConfig {

}
