package com.ai.demo;


import fan.aiflow.boot.spring.boot.starter.anotation.EnableAFlow;
import fan.aiflow.client.open.bean.Credential;
import fan.aiflow.client.open.bean.FlowServerConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.*;


@SpringBootApplication
@EnableAFlow(app = "${spring.application.name}", appName = "商品主档系统测试")
@EnableAspectJAutoProxy(exposeProxy = true)
@ComponentScan({"com.ai","fan.aiflow"})
public class DemoApplication  extends SpringBootServletInitializer {
	private Logger logger = LoggerFactory.getLogger(getClass());



	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}



	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		logger.info("准备加载启动类...");
		return application.sources(DemoApplication.class);
	}


}
