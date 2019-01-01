
package com.orange.ysy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.orange.ysy.util.SpringUtils;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan
@MapperScan(value = "com.orange.ysy.mapper")
@EnableSwagger2
public class YsyWebApplication {
	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(YsyWebApplication.class, args);
		SpringUtils.setApplicationContext(applicationContext);
	}
}