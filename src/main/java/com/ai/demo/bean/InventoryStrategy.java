package com.ai.demo.bean;

import fan.aiflow.client.open.anotation.AField;
import lombok.Data;

/**
 * 库存策略
 *
 * @author Sky
 * @since 2025/05/24
 **/
@Data
public class InventoryStrategy {

    @AField(doc = "商品编码")
    private String skuCode;

    @AField(doc = "销售安全库存")
    private Integer saleSafeInventory;

    @AField(doc = "采购安全库存")
    private Integer purchaseSafeInventory;

}
