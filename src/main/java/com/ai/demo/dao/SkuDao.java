package com.ai.demo.dao;

import com.ai.demo.bean.*;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mysql.cj.util.StringUtils;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Arrays;
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
        log.info("增加临时的skuBase: {}", skuBaseInfo);
        return skuCode;
    }
    public String createBaseInfoWithCode(SkuBaseInfo skuBaseInfo) {
        if(StringUtils.isNullOrEmpty(skuBaseInfo.getSkuCode())){
            String skuCode = UUID.randomUUID().toString();
            skuBaseInfo.setSkuCode(skuCode);
        }
        SkuInfo skuInfo = new SkuInfo();
        skuInfo.setSkuBaseInfo(skuBaseInfo);
        skuMap.put(skuBaseInfo.getSkuCode(), skuInfo);
        log.info("增加临时skuBase: {}", skuBaseInfo);
        return skuBaseInfo.getSkuCode();
    }

    public SkuInfo updateImg(String skuCode, List<ImgInfo> imgList) {
        SkuInfo skuInfo = skuMap.get(skuCode);
        if (Objects.isNull(skuInfo)) {
            log.error("商品:{}不存在", skuCode);
            SkuInfo skuInfo1 = new SkuInfo();
            SkuBaseInfo skuBaseInfo = new SkuBaseInfo();
            skuBaseInfo.setSkuCode(skuCode);
            skuBaseInfo.setSkuName("内存里缓存的商品已不存在, 应该是 在创建到执行当前节点中间 服务被重启了");
            skuInfo1.setSkuBaseInfo(skuBaseInfo);
            return skuInfo1;
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

    public SkuInfo getSkuInfo() {
        SkuBaseInfo skuBaseInfo = new SkuBaseInfo();
        skuBaseInfo.setSkuCode("1111111");
        skuBaseInfo.setSkuName("skuName");
        skuBaseInfo.setCategoryCode("categoryCode");
        skuBaseInfo.setAddress("Address");

        // 使用系统默认时区获取当前时间
        ZonedDateTime now = ZonedDateTime.now();
        // 定义格式：yyyy-MM-dd HH:mm:ss +08:00
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss XXX");
        // 格式化时间
        String formattedTime = now.format(formatter);
        skuBaseInfo.setDesc(formattedTime);


        SpecBaseInfo specBaseInfo = new SpecBaseInfo();
        specBaseInfo.setExpression("express");
        specBaseInfo.setPrice(BigDecimal.valueOf(100));
        specBaseInfo.setQty(10);
        skuBaseInfo.setSpecBaseInfoList(Arrays.asList(specBaseInfo));

        ImgInfo imgInfo = new ImgInfo();
        imgInfo.setName("imgName");
        imgInfo.setUrl("http://gips3.baidu.com/it/u=3886271102,3123389489&fm=3028&app=3028&f=JPEG&fmt=auto?w=1280&h=960");
        skuBaseInfo.setImgList(Arrays.asList(imgInfo));


        InventoryStrategy inventoryStrategy = new InventoryStrategy();
        inventoryStrategy.setSkuCode("212331");
        inventoryStrategy.setSaleSafeInventory(10);
        inventoryStrategy.setPurchaseSafeInventory(200);
        skuBaseInfo.setInventoryStrategy(inventoryStrategy);

        SkuInfo skuInfo = new SkuInfo();
        skuInfo.setSkuBaseInfo(skuBaseInfo);
        return skuInfo;
    }

    public SkuInfo defaultImg(String skuCode) {
            SkuInfo skuInfo = new SkuInfo();
            SkuBaseInfo skuBaseInfo = new SkuBaseInfo();
            skuBaseInfo.setSkuCode(skuCode);
            skuBaseInfo.setSkuName("系统生成默认商品");
            // 创建三个规格项
            List<SpecBaseInfo> specList = Arrays.asList(
                SpecBaseInfo.builder()
                    .expression("小规格")
                    .qty(1)
                    .price(BigDecimal.valueOf(99.99))
                    .build(),
                SpecBaseInfo.builder()
                    .expression("中规格")
                    .qty(2)
                    .price(BigDecimal.valueOf(199.99))
                    .build(),
                SpecBaseInfo.builder()
                    .expression("大规格")
                    .qty(3)
                    .price(BigDecimal.valueOf(299.99))
                    .build()
            );
            skuBaseInfo.setSpecBaseInfoList(specList);
            skuInfo.setSkuBaseInfo(skuBaseInfo);
            skuBaseInfo.setImgList(Lists.newArrayList(
                    ImgInfo.builder()
                            .url("http://gips3.baidu.com/it/u=3886271102,3123389489&fm=3028&app=3028&f=JPEG&fmt=auto?w=1280&h=960")
                            .name("美女1")
                            .build(),
                    ImgInfo.builder()
                            .url("http://gips3.baidu.com/it/u=100751361,1567855012&fm=3028&app=3028&f=JPEG&fmt=auto?w=960&h=1280")
                            .name("美女2")
                            .build()));
            return skuInfo;
    }
}
