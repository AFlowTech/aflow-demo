package com.ai.demo.controller;

import com.google.common.collect.Lists;
import fan.aiflow.client.open.bean.JsonResult;
import fan.aiflow.client.open.bean.req.SubFlowApplyStdApiReq;
import fan.aiflow.client.open.bean.resp.AssigneeCallbackResp;
import fan.aiflow.client.open.bean.resp.StdApiAssigneeCalcResp;
import fan.aiflow.client.open.bean.resp.SubFlowApplyStdApiResp;
import fan.aiflow.client.open.constant.UserType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("aflow/flow/demo/std/")
public class StdController {


    @PostMapping("subFlowApplyStdApi")
    public JsonResult<SubFlowApplyStdApiResp> subFlowApplyStdApi(@RequestBody SubFlowApplyStdApiReq request) {
        SubFlowApplyStdApiResp resp = new SubFlowApplyStdApiResp();

        SubFlowApplyStdApiResp.SubOrderKeyItem item1 = new SubFlowApplyStdApiResp.SubOrderKeyItem();
        item1.setKeyCode("keyCode1");
        item1.setKeyLabel("keyLabel1");

        SubFlowApplyStdApiResp.SubOrderKeyItem item2 = new SubFlowApplyStdApiResp.SubOrderKeyItem();
        item2.setKeyCode("keyCode2");
        item2.setKeyLabel("keyLabel2");
        resp.setItems(Lists.newArrayList(item1, item2));

        return JsonResult.success(resp);
    }


    @PostMapping("assigneeSdtApi")
    public JsonResult<StdApiAssigneeCalcResp> assigneeSdtApi() {
        StdApiAssigneeCalcResp resp = new StdApiAssigneeCalcResp();
        resp.setUserCodes(Lists.newArrayList("10014886","10014887","10014888","10014891","10014893","10014894","10014895","10015781","10015785","10015786","10015831"));
        resp.setUserType(UserType.AFLOW);
        return JsonResult.success(resp);
    }
}
