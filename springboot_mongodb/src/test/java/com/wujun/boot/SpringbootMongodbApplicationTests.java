package com.wujun.boot;

import com.alibaba.fastjson.JSON;
import com.wujun.boot.domain.User;
import com.wujun.boot.repository.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootMongodbApplicationTests {
	@Autowired
	private UserRepository userRepository;

	@Before
	public void setUp(){
		userRepository.deleteAll();
	}

	@Test
	public void test() {
		userRepository.save(new User(1L,"test1",30));
		userRepository.save(new User(2L,"test2",35));
		userRepository.save(new User(3L,"test3",36));
		Assert.assertEquals(3,userRepository.findAll().size());

		User u = userRepository.findOne(1L);
		System.out.println("++++++++++++++++++++ "+JSON.toJSONString(u));
		userRepository.delete(u);
		Assert.assertEquals(2,userRepository.findAll().size());

		u = userRepository.findByUsername("test3");
		System.out.println("++++++++++++++++++++ "+JSON.toJSON(u));
		userRepository.delete(u);
		Assert.assertEquals(1,userRepository.findAll().size());


	}

}
