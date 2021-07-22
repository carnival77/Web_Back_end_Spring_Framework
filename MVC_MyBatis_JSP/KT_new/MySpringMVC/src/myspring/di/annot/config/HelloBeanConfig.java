package myspring.di.annot.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = {"myspring.di.annot"})
//<!-- DI 전략 2의 Component Auto Scanning 설정 -->
//<context:component-scan
//	base-package="myspring.di.annot" />
@PropertySource("classpath:config/values.properties")
//<!-- Properties file 설정 -->
//<context:property-placeholder
//	location="classpath:config/values.properties" />
public class HelloBeanConfig {
	
}
