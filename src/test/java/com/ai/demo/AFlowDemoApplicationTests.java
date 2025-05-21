package com.ai.demo;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import javax.annotation.Resource;

import com.ai.demo.biz.AFlowBiz;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class AFlowDemoApplicationTests {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Resource
	private AFlowBiz aFlowBiz;

	@Test
	public void testGetAccessToken() {
		String token = aFlowBiz.getAccessToken("9910031941","c94b1dcd");
		logger.info(token);
		assertNotNull(token);
	}


	@Test
	public void saveQDictData() {
		Long id = aFlowBiz.saveDictData();
		logger.info(String.valueOf(id));
		assertNotNull(id);

	}


}
