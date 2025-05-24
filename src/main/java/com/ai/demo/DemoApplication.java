package com.ai.demo;


import fan.aiflow.boot.spring.boot.starter.anotation.EnableAFlow;
import fan.aiflow.client.open.bean.Credential;
import fan.aiflow.client.open.bean.FlowServerConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.*;


@SpringBootApplication
@EnableAFlow(app = "product", appName = "商品主档系统")
@EnableAspectJAutoProxy(exposeProxy = true)
@Scope(proxyMode = ScopedProxyMode.NO)
@ComponentScan({"com.ai","fan.aiflow"})
public class DemoApplication  extends SpringBootServletInitializer {
	private Logger logger = LoggerFactory.getLogger(getClass());

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public FlowServerConfig flowServerConfig(){
		return new FlowServerConfig("http://localhost:8080","http://localhost:8080","http://localhost:8080");
	}
	@Bean
	public Credential credential(){
		return new Credential("aflow","prod", "aflow","FkD58UP2noEEyUMcY68JlgZUbtgkNFa1");
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		logger.info("准备加载启动类...");
		return application.sources(DemoApplication.class);
	}
}
