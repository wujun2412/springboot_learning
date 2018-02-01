package com.wujun.boot;

import com.wujun.boot.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootRedisApplicationTests {
	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Autowired
	@Qualifier("objectRedisTemplate")
	private RedisTemplate objectRedisTemplate;

	@Test
	public void test() {
		//保存字符串
		stringRedisTemplate.opsForValue().set("aaa","111");
		Assert.assertEquals("111",stringRedisTemplate.opsForValue().get("aaa"));
	}


	@Test
	public void objectRedisTest(){
		User user = new User("test",32);
		objectRedisTemplate.opsForValue().set(user.getUserName(),user);
		Assert.assertEquals(32, ((User)objectRedisTemplate.opsForValue().get("test")).getAge().longValue());
	}



}
