package myspring.di.annot.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = {"myspring.di.annot"})
//<!-- DI ���� 2�� Component Auto Scanning ���� -->
//<context:component-scan
//	base-package="myspring.di.annot" />
@PropertySource("classpath:config/values.properties")
//<!-- Properties file ���� -->
//<context:property-placeholder
//	location="classpath:config/values.properties" />
public class HelloBeanConfig {
	
}
