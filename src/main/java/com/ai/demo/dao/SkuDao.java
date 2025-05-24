package com.ai.demo.dao;

import com.ai.demo.bean.InventoryStrategy;
import com.ai.demo.bean.SaleInfo;
import com.ai.demo.bean.SkuBaseInfo;
import com.ai.demo.bean.SkuInfo;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

/**
 * 商品数据存储
 *
 * @author Sky
 * @since 2025/05/24
 **/
@Component
@Slf4j
public class SkuDao {
    private Map<String, SkuInfo> skuMap = Maps.newHashMap();

    public String createBaseInfo(SkuBaseInfo skuBaseInfo) {
        String skuCode = UUID.randomUUID().toString();
        skuBaseInfo.setSkuCode(skuCode);
        SkuInfo skuInfo = new SkuInfo();
        skuInfo.setSkuBaseInfo(skuBaseInfo);
        skuMap.put(skuCode, skuInfo);
        return skuCode;
    }

    public SkuInfo updateImg(String skuCode, List<String> imgList) {
        SkuInfo skuInfo = skuMap.get(skuCode);
        if (Objects.isNull(skuInfo)) {
            log.error("商品:{}不存在", skuCode);
            return null;
        }
        skuInfo.getSkuBaseInfo().setImgList(imgList);
        return skuInfo;
    }

    public SkuInfo updateSaleInfo(SaleInfo saleInfo) {
        SkuInfo skuInfo = skuMap.get(saleInfo.getSkuCode());
        if (Objects.isNull(skuInfo)) {
            log.error("商品:{}不存在", saleInfo.getSkuCode());
            return null;
        }
        skuInfo.getSkuBaseInfo().setSaleInfo(saleInfo);
        return skuInfo;
    }

    public SkuInfo updateInventoryStrategy(InventoryStrategy inventoryStrategy) {
        SkuInfo skuInfo = skuMap.get(inventoryStrategy.getSkuCode());
        if (Objects.isNull(skuInfo)) {
            log.error("商品:{}不存在", inventoryStrategy.getSkuCode());
            return null;
        }
        skuInfo.getSkuBaseInfo().setInventoryStrategy(inventoryStrategy);
        return skuInfo;
    }
}
