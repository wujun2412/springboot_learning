package com.wujun;

import com.wujun.common.CommonProperties;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
	@Autowired
	private CommonProperties commonProperties;

	@Test
	public void commonPropertiesTest(){

		Assert.assertEquals("wujun的博客",commonProperties.getName());
		Assert.assertEquals("spring boot教程",commonProperties.getTitle());
		System.out.println(commonProperties.getName());
		System.out.println(commonProperties.getTitle());
		System.out.println(commonProperties.getDesc());
	}

}
