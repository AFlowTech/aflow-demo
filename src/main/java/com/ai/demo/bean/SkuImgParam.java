package com.ai.demo.bean;

import fan.aiflow.client.open.anotation.AField;
import fan.aiflow.client.open.bean.entity.AEntity;
import lombok.Data;

import java.util.List;

/**
 * @author Sky
 * @since 2025/05/24
 **/
@Data
public class SkuImgParam implements AEntity {
    @AField(doc = "商品编码")
    private String skuCode;

    @AField(doc = "商品主图")
    private String mainImg;

    @AField(doc = "商品图片")
    private List<String> imgList;
}
