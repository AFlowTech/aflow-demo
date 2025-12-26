package com.ai.demo.bean;

import fan.aiflow.client.open.anotation.AField;
import fan.aiflow.client.open.anotation.AServiceReqField;
import fan.aiflow.client.open.anotation.AServiceRespField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Sky
 * @since 2025/05/24
 **/
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SkuBaseInfo {
    /**
     * 商品编码
     */
    @AServiceRespField(doc = "商品编码",nullable = false)
    private String skuCode;
    /**
     * 商品名称
     */
    @AServiceRespField(doc = "商品名称")
    private String skuName;

    /**
     * 商品分类编码
     */
    private String categoryCode;

    /**
     * 商品描述
     */
    private String desc;

    /**
     * 产地
     */
    private String address;

    /**
     * 单价
     */
    private BigDecimal price;

    /**
     * 规格信息
     */
    private List<SpecBaseInfo> specBaseInfoList;

    /**
     * 图片信息
     */
    @AServiceRespField(doc = "图片信息")
    private List<ImgInfo> imgList;

    /**
     * 销售信息
     */
    private SaleInfo saleInfo;

    /**
     * 库存信息
     */
    private InventoryStrategy inventoryStrategy;
}
