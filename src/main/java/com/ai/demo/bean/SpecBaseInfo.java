package com.ai.demo.bean;

import fan.aiflow.client.open.anotation.AField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author jixiaoliang
 * @since 2025/05/24
 **/
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpecBaseInfo {
    /**
     * 规格描述
     */
    private String expression;

    /**
     * 换算比例
     */
    private Integer qty;

    /**
     * 价格
     */
    @AField(name = "price",fieldPath = "specBaseInfoList")
    private BigDecimal price;
}
