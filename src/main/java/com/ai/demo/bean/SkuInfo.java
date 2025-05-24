package com.ai.demo.bean;

import fan.aiflow.client.open.bean.entity.AEntity;
import lombok.Data;

/**
 * 商品信息
 * @author Sky
 * @since 2025/05/24
 **/
@Data
public class SkuInfo implements AEntity {
    /**
     * 商品基础信息
     */
    private SkuBaseInfo skuBaseInfo;
}
