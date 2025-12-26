package com.ai.demo.controller;

import com.ai.demo.bean.*;
import com.ai.demo.biz.SkuBiz;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 *
 * 商品信息准备阶段流程
 *
 * 采集商品基础信息（名称、规格、条码、成本价、零售价）
 *
 * 拍摄商品主图+场景图（白底图+3-5张使用场景图）
 *
 * 编写商品卖点（核心功能3条+使用场景描述）
 *
 * 确定库存策略（安全库存量/首批订货量）
 * @author Sku
 * @since 2025/05/24
 **/

@Slf4j
@RestController
@RequestMapping("aflow/flow/demo/sku")
public class SkuController {

    @Resource
    private SkuBiz skuBiz;
    /**
     * 新品引入
     * @return 商品编码
     */
    @PostMapping("createSku")
    public String createSku(SkuParam skuParam) {
        return skuBiz.createSku(skuParam);
    }

    @GetMapping("healthCheck")
    public String healthCheck() {
        log.info("healthCheck");
        log.warn("WARN!! healthCheck");
        log.error("ERROR!! healthCheck");

        return "OK";
    }
    

    /**
     * 完善商品图片
     * @return 商品完整信息
     */
    @PostMapping("updateImg")
    public SkuInfo updateImg(SkuImgParam skuImgParam) {
        return skuBiz.updateImg(skuImgParam);
    }

    /**
     * 编写商品卖点
     * @return 商品完整信息
     */
    @PostMapping("updateSaleInfo")
    public SkuInfo updateSaleInfo(SaleInfo saleInfo) {
        return skuBiz.updateSaleInfo(saleInfo);
    }

    /**
     * 填写库存策略
     * @return 商品完整信息
     */
    @PostMapping("updateInventoryStrategy")
    public SkuInfo updateInventoryStrategy(InventoryStrategy inventoryStrategy) {
        return skuBiz.updateInventoryStrategy(inventoryStrategy);
    }

}
