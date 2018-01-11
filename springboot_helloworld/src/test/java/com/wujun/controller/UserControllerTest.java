package com.wujun.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author wujun
 * @description
 * @date 18/1/9.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {
    private MockMvc mvc;

    @Before
    public void setUp(){
        mvc= MockMvcBuilders.standaloneSetup(new UserController()).build();
    }

    @Test
    public void testUserController() throws Exception {

        RequestBuilder request = null;

        //1.get查询user列表，应该为空
        request= get("/users/");
        mvc.perform(request).andExpect(status().isOk()).andExpect(content().string(equalTo("[]")));

        //2.post提交一个user
        request= post("/users/")
                .param("id","1")
                .param("name","测试用户")
                .param("sex","1");
        mvc.perform(request).andExpect(content().string(equalTo("success")));

        //3.get查询user列表
        request= get("/users/");
        mvc.perform(request).andExpect(status().isOk()).andExpect(content().string(equalTo("[{\"id\":1,\"name\":\"测试用户\",\"sex\":1}]")));

        //4.修改id为1的用户信息
        request = post("/users/update/1")
                .param("name","测试终极用户")
                .param("sex","2");
        mvc.perform(request).andExpect(status().isOk()).andExpect(content().string(equalTo("success")));

        //5.get id为1的用户信息
        request= get("/users/1");
        mvc.perform(request).andExpect(status().isOk()).andExpect(content().string(equalTo("{\"id\":1,\"name\":\"测试终极用户\",\"sex\":2}")));

        //6.删除id为1的用户信息
        request = get("/users/delete/1");
        mvc.perform(request).andExpect(status().isOk()).andExpect(content().string(equalTo("success")));

        //7.get查询user列表，应该为空
        request= get("/users/");
        mvc.perform(request).andExpect(status().isOk()).andExpect(content().string(equalTo("[]")));
    }
}
