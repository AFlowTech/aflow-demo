package com.ai.demo.bean;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author jixiaoliang
 * @since 2025/05/24
 **/
@Data
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
    private BigDecimal price;
}
