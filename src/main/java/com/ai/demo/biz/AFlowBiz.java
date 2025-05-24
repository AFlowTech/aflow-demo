package com.ai.demo.biz;

import fan.aiflow.client.open.FlowClient;
import fan.aiflow.client.open.anotation.AService;
import fan.aiflow.client.open.bean.CustomAuthentication;
import fan.aiflow.client.open.bean.dict.AConvertField;
import fan.aiflow.client.open.bean.dict.ADictData;
import fan.aiflow.client.open.bean.dict.ADictFieldValue;
import fan.aiflow.client.open.bean.entity.AEntity;
import fan.aiflow.client.open.bean.enums.ALinkEnterpriseType;
import fan.aiflow.client.open.util.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;


/**
 * KuaiFlowBiz
 *
 * @author sosan
 * @since 2024/09/01
 */

@Service
public class AFlowBiz {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private FlowClient flowClient;

    @Value("${a.flow.enterpriseCode}")
    private String enterpriseCode;

    @Value("${a.flow.appId}")
    private String appId;

    @Value("${a.flow.appSecret}")
    private String appSecret;

    //环境[beta:测试/prod:线上]
    @Value("${a.flow.environmentType}")
    private String environmentType;

    @Value("${a.flow.serverConfig.prodDomain}")
    private String prodDomain;

    @Value("${a.flow.serverConfig.prodBackDomain}")
    private String prodBakDomain;

    @Value("${a.flow.serverConfig.betaDomain}")
    private String betaDomain;

    @PostConstruct
    public void init() {
        // 实例化一个FlowClient、为了保护密钥安全，建议将密钥设置在环境变量中或者配置文件中。
        // Credential cred = new Credential("enterpriseCode","beta", "appId","appSecret");
       // Credential credential = new Credential(enterpriseCode, environmentType, appId, appSecret);
       // flowClient = new FlowClient(credential);

        //如果你是私有化布署、你的服务端域名需要按实际公司的传入、否则会调用到AFlow的云Saas服务 ，代码修改如下
        //FlowServerConfig flowServerConfig =new FlowServerConfig(prodDomain,prodBakDomain,betaDomain);
        //flowClient = new FlowClient(credential,flowServerConfig);
    }

    public String getAccessToken(String customUserCode, String linkUserCode) {
        CustomAuthentication customAuthentication = new CustomAuthentication();
        // 企业的用户编码-这里获取当前登陆用户的企业userCode、即贵公司的用户唯一Id
        // customAuthentication.setCustomUserCode(UserContext.getUserCode());
        customAuthentication.setCustomUserCode(customUserCode);
        // 贵公司使用的三方平台用户编码、如飞书Id
        // customAuthentication.setLinkUserCode(UserContext.getLinkUserCode());
        customAuthentication.setLinkUserCode(linkUserCode);
        return flowClient.getAccessToken(customAuthentication);
    }

    public Long saveDictData() {
        ADictData qDictData = ADictData.builder()
                .dictCode("shop")
                .fieldValues(new ArrayList<>(Arrays.asList(ADictFieldValue.of("shopCode", "100000"),
                        ADictFieldValue.of("shopName", "望京店22"),
                        ADictFieldValue.of("showOwner", "c94b1dcd"))))
                .convertUserCodeFields(new HashSet<>(Arrays.asList(AConvertField.builder().fieldCode("showOwner")
                        .linkEnterpriseType(ALinkEnterpriseType.FEISHU)
                        .build())))
                .build();
        return flowClient.saveDictData(qDictData);
    }


    public Long startFlow() {
        return null;
    }
}
