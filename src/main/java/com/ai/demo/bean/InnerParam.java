package com.ai.demo.bean;


import fan.aiflow.client.open.anotation.AField;

/**
 * @author jixiaoliang
 * @since 2025/04/28
 **/
@AField( doc = "内部参数")
public class InnerParam {
    @AField( doc = "内部编码")
    private String innerCode;

    @AField( doc = "内部名称",required = true)
    private String innerName;

    @AField( doc = "二级内部参数")
    private InnerParam1 innerParam;

    public String getInnerCode() {
        return innerCode;
    }

    public void setInnerCode(String innerCode) {
        this.innerCode = innerCode;
    }

    public String getInnerName() {
        return innerName;
    }

    public void setInnerName(String innerName) {
        this.innerName = innerName;
    }

    public InnerParam1 getInnerParam() {
        return innerParam;
    }

    public void setInnerParam(InnerParam1 innerParam) {
        this.innerParam = innerParam;
    }
}
