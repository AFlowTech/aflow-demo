package com.ai.demo.bean;

import fan.aiflow.client.open.anotation.AField;
import fan.aiflow.client.open.anotation.AServiceReqField;
import fan.aiflow.client.open.bean.entity.AEntity;
import lombok.Data;

/**
 * @author Sky
 * @since 2025/05/24
 **/
@Data
public class SaleInfo implements AEntity {
    @AServiceReqField(doc = "商品名")
    private String skuCode;

    @AServiceReqField(doc = "卖点")
    private String sellingPoint;

    @AServiceReqField(doc = "促销词")
    private String promotionalSlogans;

}
