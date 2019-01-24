package com.wujun.boot.controller;

import com.wujun.boot.redis.RedisSecKillDao;
import com.wujun.common.core.util.RedisUtils;
import com.wujun.common.responses.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wujun
 * @description
 * @date 19/1/23.
 */
@RestController
@RequestMapping("/buy")
public class SecondKillController {

    /**
     * 秒杀库存key
     */
    public static final String INVENTORY_REDIS_KEY = "com:wujun:seckill:inventory:01";

    @Autowired
    private RedisSecKillDao secKillDao;

    @RequestMapping(value = "/seckill", method = RequestMethod.POST)
    public ApiResult secondkill() {
        Integer result = secKillDao.secKill(INVENTORY_REDIS_KEY);
        if (result == 1) {
            return ApiResult.SUCCESS("秒杀成功!");
        } else {
            return ApiResult.FAIL("当前秒杀人数太多，请稍后重试!");
        }
    }

    @RequestMapping(value = "/init", method = RequestMethod.GET)
    public ApiResult initInventory(@RequestParam("count") Integer count) {
        RedisUtils.put(INVENTORY_REDIS_KEY, count, -1);
        return ApiResult.SUCCESS();
    }

    @RequestMapping(value = "/decr", method = RequestMethod.GET)
    public ApiResult initInventory() {
        Long result = RedisUtils.decr(INVENTORY_REDIS_KEY);
        return ApiResult.SUCCESS();
    }

}
