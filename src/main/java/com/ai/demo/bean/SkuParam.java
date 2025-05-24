package com.ai.demo.bean;

import fan.aiflow.client.open.anotation.AField;
import fan.aiflow.client.open.bean.entity.AEntity;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Sky
 * @since 2025/05/24
 **/
@Data
public class SkuParam implements AEntity {
    @AField(doc = "商品名")
    private String skuName;

    @AField(doc = "商品分类编码")
    private String categoryCode;

    @AField(doc = "商品描述")
    private String desc;

    @AField(doc = "产地")
    private String address;

    @AField(doc = "价格")
    private BigDecimal price;

    @AField(doc = "规格")
    private List<SpecParam> specParamList;
}
