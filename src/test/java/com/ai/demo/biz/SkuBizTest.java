package com.ai.demo.biz;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import com.ai.demo.DemoApplication;
import com.ai.demo.bean.SkuParam;
import com.ai.demo.bean.SpecBaseInfo;
import com.google.common.collect.Lists;

import lombok.extern.slf4j.Slf4j;
import javax.annotation.Resource;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class SkuBizTest {
    @Resource
    private SkuBiz skuBiz;


    @Test
    void testCreateSku() {
        

    }

    @Test
    void testCreateSkuWithCode() {
        SkuParam skuParam = new SkuParam();
        skuParam.setSkuCode("10000");
        skuParam.setSkuName("洗面奶");
        skuParam.setPrice(new BigDecimal(20));
        skuParam.setCategoryCode("1000");
        skuParam.setDesc("测试");
        skuParam.setAddress("北京");
        // skuParam.setSpecParamList(Lists.newArrayList(SpecBaseInfo.builder().qty(1).expression("1*19").price(new BigDecimal(100)).build()));

        log.info("skuParam:{}",skuParam);
        String skuCode2 = skuBiz.createSkuWithCode(skuParam);
        assert skuCode2.equals("10000");

    }
}
