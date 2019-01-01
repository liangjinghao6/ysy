package com.orange.ysy.filter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

	@Bean
	public FilterRegistrationBean getDemoFilter() {
		LoginFilter demoFilter = new LoginFilter();
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.setFilter(demoFilter);
		List<String> urlPatterns = new ArrayList<String>();
		urlPatterns.add("/*");// 拦截路径，可以添加多个
		registrationBean.setUrlPatterns(urlPatterns);
		registrationBean.setOrder(1);
		return registrationBean;
	}

	// @Bean
	// public ServletRegistrationBean DruidStatViewServle2() {
	//
	// //
	// org.springframework.boot.context.embedded.ServletRegistrationBean提供类的进行注册.
	// ServletRegistrationBean servletRegistrationBean = new
	// ServletRegistrationBean(new StatViewServlet(),
	// "/druid2/*");
	// // 添加初始化参数：initParams
	//
	// // 白名单：
	// servletRegistrationBean.addInitParameter("allow", "127.0.0.1");
	// // IP黑名单 (存在共同时，deny优先于allow) : 如果满足deny的话提示:Sorry, you are not
	// // permitted to view this page.
	// servletRegistrationBean.addInitParameter("deny", "192.168.1.73");
	// // 登录查看信息的账号密码.
	// servletRegistrationBean.addInitParameter("loginUsername", "admin2");
	// servletRegistrationBean.addInitParameter("loginPassword", "123456");
	// // 是否能够重置数据.
	// servletRegistrationBean.addInitParameter("resetEnable", "false");
	// return servletRegistrationBean;
	// }
}