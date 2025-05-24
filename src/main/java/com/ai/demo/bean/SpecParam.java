package com.ai.demo.bean;

import fan.aiflow.client.open.anotation.AField;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author jixiaoliang
 * @since 2025/05/24
 **/
@Data
public class SpecParam {
    @AField(doc = "规格描述")
    private String expression;

    @AField(doc = "换算比例")
    private Integer qty;

    @AField(doc = "价格")
    private BigDecimal price;
}
