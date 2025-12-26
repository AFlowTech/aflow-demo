package com.ai.demo.bean;

import fan.aiflow.client.open.anotation.AField;
import fan.aiflow.client.open.anotation.AServiceFieldIgnore;
import fan.aiflow.client.open.anotation.AServiceReqField;
import fan.aiflow.client.open.bean.entity.AEntity;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author Sky
 * @since 2025/05/24
 **/
@Data
public class SkuParam implements AEntity {

    @AServiceReqField(doc = "商品编码")
    private String skuCode;

    @AServiceReqField(doc = "商品名")
    private String skuName;

    @AServiceReqField(doc = "商品分类编码")
    private String categoryCode;

    @AServiceReqField(doc = "商品描述")
    private String desc;

    @AServiceReqField(doc = "产地")
    private String address;

    @AServiceReqField(doc = "价格")
    private BigDecimal price;

    @AServiceReqField(doc = "规格")
    private List<SpecParam> specParamList;

    @AServiceReqField(doc = "不支持的类型")
    @AServiceFieldIgnore
    private Map<String, String> unSupportType;

    private String newDesc;
}
