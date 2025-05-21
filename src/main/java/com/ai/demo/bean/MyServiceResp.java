package com.ai.demo.bean;

import com.aflow.client.open.bean.entity.AEntity;

/**
 * @author jixiaoliang
 * @since 2025/04/28
 **/
public class MyServiceResp implements AEntity {

    private String code;

    private String name;

    private InnerResp innerResp;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public InnerResp getInnerResp() {
        return innerResp;
    }

    public void setInnerResp(InnerResp innerResp) {
        this.innerResp = innerResp;
    }
}
