package com.ai.demo.bean;


import fan.aiflow.client.open.anotation.AField;

/**
 * @author jixiaoliang
 * @since 2025/04/28
 **/
@AField( doc = "内部参数")
public class InnerParam1 {
    @AField( doc = "内部编码")
    private String innerCode;

    @AField( doc = "内部名称",required = true)
    private String innerName;


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

}
