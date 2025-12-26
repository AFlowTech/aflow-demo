package com.ai.demo.bean;

import fan.aiflow.client.open.anotation.AField;
import fan.aiflow.client.open.anotation.AServiceReqField;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author jixiaoliang
 * @since 2025/05/24
 **/
@Data
public class SpecParam {
    @AServiceReqField(doc = "规格描述")
    private String expression;

    @AServiceReqField(doc = "换算比例")
    private Integer qty;

    @AServiceReqField(doc = "价格")
    private BigDecimal price;

    private String unit;

    private String newDesc;
}
