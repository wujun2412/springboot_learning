
#Redis 秒杀demo

// 负库存控制 watch下加库存判断
public Integer secKill(final String storeKey) {
        return (Integer) redisTemplate.execute(new RedisCallback() {
            @Override
            public Integer doInRedis(RedisConnection connection) {
                System.out.println("秒杀中。。。。。");
                Integer ret = 0;
                connection.watch(storeKey.getBytes());
                Integer remain = get(storeKey,connection);
                if (remain <= 0){
                    throw XExceptionFactory.create("ERROR_SECOND_KILL_0001","");
                }
                connection.multi();
                String canBuyKey = CAN_BUY_PREFIX + RandomUtils.randomInt(8);
                String canBuyValue = "1";
                connection.set(canBuyKey.getBytes(), canBuyValue.getBytes());
                // 扣库存
                connection.decrBy(SafeEncoder.encode(storeKey), 1);
                connection.exec();

                byte[] bytes = connection.get(canBuyKey.getBytes());
                if (bytes != null && canBuyValue.equals(new String(bytes))) {
                    ret = 1;
                    connection.del(canBuyKey.getBytes());
                }
                return ret;
            }
        }, true);
    }