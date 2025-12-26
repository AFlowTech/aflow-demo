package com.ai.demo.controller;

import com.ai.demo.biz.AFlowBiz;
import fan.aiflow.client.open.bean.JsonResult;
import fan.aiflow.client.open.bean.order.param.AStartParam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * demo
 */
@RestController
@RequestMapping("aflow/flow/demo/")
public class AFlowController {

    @Resource
    private AFlowBiz aFlowBiz;

    @GetMapping("getAccessToken")
    public JsonResult<String> getAccessToken(@RequestParam String customUserCode
            , @RequestParam String linkUserCode) {
        //从登陆上下文获取、以及获取到飞书/钉钉Id
        return JsonResult.success(aFlowBiz.getAccessToken(customUserCode, linkUserCode));
    }

    @GetMapping("handleFlow")
    public JsonResult<Boolean> handleFlow(@RequestParam String orderId,
                                          @RequestParam String customUserCode,
                                          @RequestParam String operate) {
        // 指定流程和处理人还有处理方式
        return JsonResult.success(aFlowBiz.handleFLow(orderId, customUserCode, operate));
    }
}
