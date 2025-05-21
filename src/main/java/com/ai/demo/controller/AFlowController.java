package com.ai.demo.controller;

import javax.annotation.Resource;

import com.ai.demo.biz.AFlowBiz;
import fan.aiflow.client.open.bean.JsonResult;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * demo
 */
@RestController
@RequestMapping("aflow/flow/demo/")
public class AFlowController {

    @Resource
    private AFlowBiz aFlowBiz;

    /**
     * 发起订单
     */
    @PostMapping("start_flow")
    public JsonResult<Long> startFlow() {
        return JsonResult.success(aFlowBiz.startFlow());
    }

    /**
     * 测试client
     */
    @GetMapping("testClient")
    public JsonResult<String> testClient() {
        return JsonResult.success(aFlowBiz.testClient());
    }


    @GetMapping("getAccessToken")
    public JsonResult<String> getAccessToken() {
        //从登陆上下文获取、以及获取到飞书/钉钉Id
        String customUserCode ="";
        String linkUserCode = "";
        return JsonResult.success(aFlowBiz.getAccessToken(customUserCode,linkUserCode));
    }
}
