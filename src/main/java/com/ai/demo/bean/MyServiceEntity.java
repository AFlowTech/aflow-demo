package com.ai.demo.bean;

import com.aflow.client.open.anotation.AField;
import com.aflow.client.open.bean.entity.AEntity;

import java.util.List;

/**
 * @author Sky
 * @since 2025/04/28
 **/
public class MyServiceEntity implements AEntity {


    @AField(doc = "门店编码",required = false)
    private String shopCode;


    @AField(doc = "门店名称",required = true)
    private String shopName;

    private InnerParam innerParam;

    private List<InnerParam> list;


    public String getShopCode() {
        return shopCode;
    }

    public void setShopCode(String shopCode) {
        this.shopCode = shopCode;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public InnerParam getInnerParam() {
        return innerParam;
    }

    public void setInnerParam(InnerParam innerParam) {
        this.innerParam = innerParam;
    }

    public List<InnerParam> getList() {
        return list;
    }

    public void setList(List<InnerParam> list) {
        this.list = list;
    }
}
