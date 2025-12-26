package com.ai.demo.biz;

import fan.aiflow.client.open.FlowClient;
import fan.aiflow.client.open.bean.CustomAuthentication;
import fan.aiflow.client.open.bean.dict.ADictData;
import fan.aiflow.client.open.bean.order.AFlowOrder;
import fan.aiflow.client.open.bean.order.param.AHandleParam;
import fan.aiflow.client.open.bean.order.param.AStartParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * KuaiFlowBiz
 *
 * @author sosan
 * @since 2024/09/01
 */

@Service
public class AFlowBiz {
    @Resource
    private FlowClient flowClient;

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

    public Long saveDictData(ADictData aDictData) {
        return flowClient.saveDictData(aDictData);
    }

    /**
     * 发起流程
     *
     * @param aStartParam 流程基本信息
     * @param data        业务方对象、对应表单实体
     * @param <T>         表单实体
     * @return 订单号
     */
    public <T> Long startFlow(AStartParam aStartParam, T data) {
        return flowClient.start(aStartParam, data);
    }

    /**
     * 处理流程
     *
     * @param data 业务方对象、对应表单实体
     * @param <T>  处理表单实体
     * @return 订单号
     */
    public <T> boolean handleFLow(String orderId, String customUserCode, String operate, T data) {
        AHandleParam aHandleParam = AHandleParam.builder()
                .orderId(Long.parseLong(orderId))
                .customUserCode(customUserCode)
                .operateType(operate) // FlowOperatorEnum
                .build();

        return flowClient.handle(aHandleParam, data);
    }


    /**
     * 通过订单号查询订单详情
     *
     * @param orderId 订单号
     * @return 订单信息
     */
    public AFlowOrder queryByOrderId(Long orderId) {
        return flowClient.queryByOrderId(orderId);
    }
}
