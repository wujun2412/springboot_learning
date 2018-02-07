package com.wujun.boot;

import com.wujun.boot.domain.User;
import com.wujun.common.core.util.RedisUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootRedisApplicationTests {
	@Autowired
	private StringRedisTemplate stringRedisTemplate;

//	@Autowired
//	@Qualifier("objectRedisTemplate")
//	private RedisTemplate objectRedisTemplate;

	@Test
	public void test() {
		//保存字符串
		stringRedisTemplate.opsForValue().set("aaa","111");
		Assert.assertEquals("111",stringRedisTemplate.opsForValue().get("aaa"));
	}


//	@Test
//	public void objectRedisTest(){
//		User user = new User("test",32);
//		objectRedisTemplate.opsForValue().set(user.getUserName(),user);
//		Assert.assertEquals(32, ((User)objectRedisTemplate.opsForValue().get("test")).getAge().longValue());
//	}

	@Test
	public void redisUtilTest(){
		User user = new User("test5",32);
		RedisUtils.put(user.getUserName(),user);

		User user2 =RedisUtils.get(user.getUserName(),User.class);
		Assert.assertEquals(user2.getAge(),user.getAge());
	}


	@Test
	public void removeKeyTest(){
		User user = new User("test5",32);
		System.out.println("++++++++++++++++++++++++++++++++"+RedisUtils.ttl(user.getUserName()));
		RedisUtils.remove(user.getUserName());
	}







}
