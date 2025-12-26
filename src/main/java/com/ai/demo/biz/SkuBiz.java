package com.ai.demo.biz;

import com.ai.demo.bean.*;
import com.ai.demo.dao.SkuDao;
import com.google.common.collect.Lists;
import fan.aiflow.client.open.Assert;
import fan.aiflow.client.open.anotation.AService;
import fan.aiflow.client.open.bean.entity.AEntity;
import fan.aiflow.client.open.exception.StatusCodeException;
import fan.aiflow.client.open.util.AvroUtil;
import fan.aiflow.client.open.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 商品服务
 *
 * @author Sky
 * @since 2025/05/24
 **/
@Slf4j
@Component
public class SkuBiz {

    @Resource
    private SkuDao skuDao;


    public static void main(String[] args) {
        // Method createSku = Lists.newArrayList(SkuBiz.class.getMethods()).stream().filter(x -> x.getName().contains("createSku")).findFirst().get();
        //System.out.println(AvroUtil.calcRespSchema(createSku));
        String param = "{\"imgList\":[{}]}";
        Object flowEntity = (AEntity) JsonUtil.of(param, SkuImgParam.class);
        System.out.println(flowEntity);

    }

    @AService(name = "新品引入", description = "新品引入,商品MD提报人填写商品基础信息")
    public String createSku(SkuParam skuParam) {
        //构造商品基础信息
        SkuBaseInfo skuBaseInfo = buildSkuBaseInfo(skuParam);
        if(!StringUtils.isEmpty(skuParam.getSkuName())) {
            Assert.isTrue(!skuParam.getSkuName().contains("$"), "商品名称不能包含$ 符号");
        }
        return skuDao.createBaseInfo(skuBaseInfo);
    }


    @AService(name = "新品引入-使用指定商品编码", description = "新品引入,商品MD提报人填写商品基础信息-允许使用指定的商品编码")
    public String createSkuWithCode(SkuParam skuParam) {
        //构造商品基础信息
        log.info("createSkuWithCode--> skuParam={}", skuParam);
        SkuBaseInfo skuBaseInfo = buildSkuBaseInfo(skuParam);
        //Assert.notEmpty(skuParam.getSkuName(), "商品名称不能为空");
        if(!StringUtils.isEmpty(skuParam.getSkuName())) {
            Assert.isTrue(!skuParam.getSkuName().contains("$"), "商品名称不能包含$ 符号");
        }
        return skuDao.createBaseInfoWithCode(skuBaseInfo);
    }

    @AService(name = "报错报错", description = "专门用于报错service，检验重试和报警通知能力")
    public String raiseBigException(SkuParam skuParam) {
        //构造商品基础信息
        log.info("raiseBigException--> skuParam={}", skuParam);
        int errCode = -999;
        if (!StringUtils.isEmpty(skuParam.getSkuCode())) {
            errCode = Integer.parseInt(skuParam.getSkuCode());
        }
        if(errCode > 1024){
            return String.valueOf(errCode);
        }
        throw new StatusCodeException(errCode, "故意报错, 错误码: " + errCode);
    }


    @AService(name = "参数小于10就报错", description = "专门用于报错service，检验重试和报警通知能力")
    public String error10(SkuParam skuParam) {
        //构造商品基础信息
        log.info("error10--> skuParam={}", skuParam);
        int i = Integer.parseInt(skuParam.getSkuCode());
        if (i < 10) {
            throw new StatusCodeException(500, "故意报错, 错误码: " + i);
        }
        return "success";
    }



    @AService(name = "参数加1", description = "专门用于报错service，检验重试和报警通知能力")
    public String add1(SkuParam skuParam) {
        //构造商品基础信息
        log.info("add1--> skuParam={}", skuParam);
        int i = Integer.parseInt(skuParam.getSkuCode());

        return String.valueOf(i+1);
    }

    @AService(name = "超时任务", description = "传入超时时间")
    public String sleepAwhile(SkuParam skuParam) {
        //构造商品基础信息
        log.info("等待一段时间--> skuParam={}", skuParam);
        int sleepTime = 3;
        if (!StringUtils.isEmpty(skuParam.getPrice())) {
            sleepTime = skuParam.getPrice().intValue();
        }
        for (int i = 0; i < sleepTime; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        log.info("执行等待 {}s", sleepTime);
        return System.nanoTime() + "";
    }

    private static SkuBaseInfo buildSkuBaseInfo(SkuParam skuParam) {
        SkuBaseInfo skuBaseInfo = new SkuBaseInfo();
        BeanUtils.copyProperties(skuParam, skuBaseInfo);
        skuBaseInfo.setSpecBaseInfoList(skuParam.getSpecParamList().stream().map(x -> {
            SpecBaseInfo specBaseInfo = new SpecBaseInfo();
            BeanUtils.copyProperties(x, specBaseInfo);
            return specBaseInfo;
        }).collect(Collectors.toList()));
        return skuBaseInfo;
    }


    @AService(name = "商品默认图片", description = "商品默认图片")
    public SkuInfo defaultImg(SkuImgParam skuImgParam) {
        return skuDao.defaultImg(skuImgParam.getSkuCode());
    }

    @AService(name = "上传商品图片", description = "图片设计师上传商品图片")
    public SkuInfo updateImg(SkuImgParam skuImgParam) {
        return skuDao.updateImg(skuImgParam.getSkuCode(), skuImgParam.getImgList());
    }

    @AService(name = "获取SkuInfo对象", description = "获取写死的对象数据，用于测试赋值")
    public SkuInfo getFakeSkuInfo(SkuImgParam skuImgParam) {
        return skuDao.getSkuInfo();
    }

    @AService(name = "更新销售信息", description = "促销员填写商品卖点等信息")
    public SkuInfo updateSaleInfo(SaleInfo saleInfo) {
        return skuDao.updateSaleInfo(saleInfo);
    }

    @AService(name = "更新库存策略", description = "库存策略等信息维护")
    public SkuInfo updateInventoryStrategy(InventoryStrategy inventoryStrategy) {
        return skuDao.updateInventoryStrategy(inventoryStrategy);
    }

    //@AService(name = "返回复杂表单",description = "返回复杂表单数据")
    public List<ComplexObj> generateComplexForm(SkuParam skuParam) {
        // 返回一个复杂的对象，包含list, 而list中又包含类似结构的对象，要求3级以上嵌套
        List<ComplexObj> result = new ArrayList<>();
        ComplexObj complexObj = new ComplexObj();
        complexObj.setName("111");
        complexObj.setSkuBaseInfoList(Arrays.asList(skuDao.getSkuInfo()));
        result.add(complexObj);
        return result;
    }
}
