package com.ai.demo.biz;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.kuaiflow.client.open.FlowClient;
import com.kuaiflow.client.open.bean.Credential;
import com.kuaiflow.client.open.bean.CustomAuthentication;
import com.kuaiflow.client.open.bean.dict.QConvertField;
import com.kuaiflow.client.open.bean.dict.QDictData;
import com.kuaiflow.client.open.bean.dict.QDictFieldValue;
import com.kuaiflow.client.open.bean.enums.QLinkEnterpriseType;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


/**
 * KuaiFlowBiz
 *
 * @author sosan
 * @since 2024/09/01
 */
@Service
public class AFlowBiz {

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

    @PostConstruct
    public void init() {
        // 实例化一个FlowClient、为了保护密钥安全，建议将密钥设置在环境变量中或者配置文件中。
        // Credential cred = new Credential("enterpriseCode","beta", "appId","appSecret");
        Credential credential = new Credential(enterpriseCode, environmentType, appId, appSecret);
        flowClient = new FlowClient(credential);
    }

    public String getAccessToken(String customUserCode,String linkUserCode) {
        CustomAuthentication customAuthentication = new CustomAuthentication();
        // 企业的用户编码-这里获取当前登陆用户的企业userCode、即贵公司的用户唯一Id
        // customAuthentication.setCustomUserCode(UserContext.getUserCode());
        customAuthentication.setCustomUserCode(customUserCode);
        // 贵公司使用的三方平台用户编码、如飞书Id
        // customAuthentication.setLinkUserCode(UserContext.getLinkUserCode());
        customAuthentication.setLinkUserCode(linkUserCode);
        return flowClient.getAccessToken(customAuthentication);
    }

    public Long saveQDictData() {
        QDictData qDictData = QDictData.builder()
                .dictCode("shop")
                .fieldValues(Lists.newArrayList(
                        QDictFieldValue.of("shopCode", "100000"),
                        QDictFieldValue.of("shopName", "望京店22"),
                        QDictFieldValue.of("showOwner", "c94b1dcd")
                ))
                .convertUserCodeFields(Sets.newHashSet(
                        QConvertField.builder().fieldCode("showOwner")
                                .linkEnterpriseType(QLinkEnterpriseType.FEISHU)
                                .build()))
                .build();
        return flowClient.saveQDictData(qDictData);
    }


    public Long startFlow() {
        return null;
    }
}
