package com.ai.demo;

import fan.aiflow.client.open.bean.Credential;
import fan.aiflow.client.open.bean.FlowServerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * @author Sky
 * @since 2025/06/05
 **/
@Configuration
public class EnvConfig {

    @Bean
    public Credential credential(Environment env) {
        String enterpriseCode = env.getProperty("a.flow.enterpriseCode");
        String appId = env.getProperty("a.flow.appId");
        String appSecret = env.getProperty("a.flow.appSecret");
        return new Credential(enterpriseCode,  appId, appSecret);
    }

    @Bean
    public FlowServerConfig flowServerConfig(Environment env) {
        String prodDomain = env.getProperty("a.flow.serverConfig.prodDomain");
        String prodBackDomain = env.getProperty("a.flow.serverConfig.prodBackDomain");
        String betaDomain = env.getProperty("a.flow.serverConfig.betaDomain");
        return new FlowServerConfig(prodDomain, prodBackDomain);
    }

}
