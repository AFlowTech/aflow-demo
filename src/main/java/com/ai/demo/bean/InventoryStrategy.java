package com.ai.demo.bean;

import fan.aiflow.client.open.anotation.AField;
import fan.aiflow.client.open.anotation.AServiceReqField;
import fan.aiflow.client.open.bean.entity.AEntity;
import lombok.Data;

/**
 * 库存策略
 *
 * @author Sky
 * @since 2025/05/24
 **/
@Data
public class InventoryStrategy implements AEntity {

    @AServiceReqField(doc = "商品编码")
    private String skuCode;

    @AServiceReqField(doc = "销售安全库存")
    private Integer saleSafeInventory;

    @AServiceReqField(doc = "采购安全库存")
    private Integer purchaseSafeInventory;

}
