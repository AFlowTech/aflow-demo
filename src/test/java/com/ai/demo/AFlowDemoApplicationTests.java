package com.ai.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

import javax.annotation.Resource;

import com.ai.demo.bean.ImgInfo;
import com.ai.demo.bean.SkuBaseInfo;
import com.ai.demo.bean.SpecBaseInfo;
import com.ai.demo.biz.AFlowBiz;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.google.common.collect.Lists;
import fan.aiflow.client.open.FlowClient;
import fan.aiflow.client.open.bean.dict.ADictData;
import fan.aiflow.client.open.bean.dict.ADictFieldValue;
import fan.aiflow.client.open.bean.order.param.AStartParam;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class AFlowDemoApplicationTests {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Resource
	private AFlowBiz aFlowBiz;

	@Resource
	@Mock
	private FlowClient flowClient;

	public final String userCode = "9910031941";
	private final String linkUserCode = "48gf8b19";

	@Before
	public void setup() {

		MockitoAnnotations.initMocks(this);  // Initialize mocks if using annotations
		// OR
		flowClient = mock(FlowClient.class);  // If not using annotations
	}

	@Test
	public void testGetAccessToken() {
		String actualToken = aFlowBiz.getAccessToken(userCode, linkUserCode);
		assertNotNull(actualToken);
	}

	@Test
	public void saveADictData() {
		ADictData aDictData = ADictData.builder()
				.dictCode("shopInfo")
				.fieldValues(new ArrayList<>(Arrays.asList(ADictFieldValue.of("shopCode", "100000"),
						ADictFieldValue.of("shopName", "望京店22"),
						ADictFieldValue.of("shopOwner", userCode))))
				.build();
		Long id = aFlowBiz.saveDictData(aDictData);
		logger.info(String.valueOf(id));
		assertNotNull(id);
	}

	@Test
	public void testStartFlow() {
		String skuCode= "10000";
		AStartParam aStartParam = AStartParam.builder()
				.flowCode("389000330")
				.businessKey(skuCode)
				.customUserCode(userCode)
				.build();

		SkuBaseInfo baseInfo = SkuBaseInfo.builder()
				.skuCode(skuCode)
				.skuName("洗面奶")
				.price(new BigDecimal(20))
				.categoryCode("1000")
				.desc("测试")
				.address("北京")
				.specBaseInfoList(Lists.newArrayList(SpecBaseInfo.builder().qty(1).expression("1*19").price(new BigDecimal(100)).build()))
				.imgList(Lists.newArrayList(ImgInfo.builder().name("main").url("https://aiflow.fan/aflow/ee15f11d-7b4d-4296-89c0-e1dc4b6a01ed.jpeg").build()))
				.build();
		Long orderId = aFlowBiz.startFlow(aStartParam,baseInfo);
		assertTrue(orderId!=null && orderId>1);
	}

}
