package com.ai.demo.bean;

import java.util.List;

import lombok.Data;

/**
 * 一个复杂的对象，包含list, 而list中又包含类似结构的对象，要求3级以上嵌套
 */
@Data
public class ComplexObj {
    String name;
    List<SkuInfo> skuBaseInfoList;

}
