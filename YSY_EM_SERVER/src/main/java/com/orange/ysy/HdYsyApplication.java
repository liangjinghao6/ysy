
package com.orange.ysy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.orange.ysy.util.SpringUtils;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan
//@EnableAutoConfiguration
//@EnableJpaRepositories(basePackages = {"com.orange.ysy.mapper"})
@EnableSwagger2
public class HdYsyApplication {
	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(HdYsyApplication.class, args);
		SpringUtils.setApplicationContext(applicationContext);
	}
}