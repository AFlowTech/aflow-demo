package com.ai.demo.biz;

import com.ai.demo.bean.*;
import com.ai.demo.dao.SkuDao;
import fan.aiflow.client.open.anotation.AService;
import org.springframework.beans.BeanUtils;

import javax.annotation.Resource;
import java.util.stream.Collectors;

/**
 * 商品服务
 * @author Sky
 * @since 2025/05/24
 **/
public class SkuBiz {

    @Resource
    private SkuDao skuDao;


    @AService(name = "新品引入",description = "新品引入,商品MD提报人填写商品基础信息")
    public String createSku(SkuParam skuParam) {
        //构造商品基础信息
        SkuBaseInfo skuBaseInfo = buildSkuBaseInfo(skuParam);

        return skuDao.createBaseInfo(skuBaseInfo);
    }

    private static SkuBaseInfo buildSkuBaseInfo(SkuParam skuParam) {
        SkuBaseInfo skuBaseInfo = new SkuBaseInfo();
        BeanUtils.copyProperties(skuParam,skuBaseInfo);
        skuBaseInfo.setSpecBaseInfoList(skuParam.getSpecParamList().stream().map(x->{
            SpecBaseInfo specBaseInfo = new SpecBaseInfo();
            BeanUtils.copyProperties(x,specBaseInfo);
            return specBaseInfo;
        }).collect(Collectors.toList()));
        return skuBaseInfo;
    }

    @AService(name = "上传商品图片",description = "图片设计师上传商品图片")
    public SkuInfo updateImg(SkuImgParam skuImgParam) {
        return skuDao.updateImg(skuImgParam.getSkuCode(),skuImgParam.getImgList());
    }

    @AService(name = "更新销售信息",description = "促销员填写商品卖点等信息")
    public SkuInfo updateSaleInfo(SaleInfo saleInfo) {
        return skuDao.updateSaleInfo(saleInfo);
    }

    @AService(name = "更新库存策略",description = "库存策略等信息维护")
    public SkuInfo updateInventoryStrategy(InventoryStrategy inventoryStrategy) {
        return skuDao.updateInventoryStrategy(inventoryStrategy);
    }
}
