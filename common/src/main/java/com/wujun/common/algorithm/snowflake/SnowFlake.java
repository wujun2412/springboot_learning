package com.wujun.common.algorithm.snowflake;

/**
 * @author wujun
 * @description Twitter的SnowFlake算法,使用SnowFlake算法生成一个整数，然后转化为62进制变成一个短地址URL
 * @date 18/4/24.
 */
public class SnowFlake {

    /**
     * 起始的时间戳
     */
    private final static long START_TIMESTAMP = 1524554821646L;

    /**每一部分占用的位数**/
    /**
     * 序列号占用的位数
     */
    private final static long SEQUENCE_BIT = 12;
    /**
     * 机器标识占用位数
     */
    private final static long MACHINE_BIT = 5;

    /**
     * 数据中心占用位数
     */
    private final static long DATA_CENTER_BIT =5;

    /**
     * 计算每一部分的最大值
     */
    private final static long MAX_SEQUENCE = -1L ^ (-1L << SEQUENCE_BIT);
    private final static long MAX_MACHINE_NUM = -1L ^ (-1L << MACHINE_BIT);
    private final static long MAX_DATA_CENTER_NUM = -1L ^ (-1L << DATA_CENTER_BIT);

    /**
     * 每一部分向左的位移
     */
    private final static long MACHINE_LEFT = SEQUENCE_BIT;
    private final static long DATA_CENTER_LEFT = SEQUENCE_BIT + MACHINE_BIT;
    private final static long TIMESTAMP_LEFT = DATA_CENTER_LEFT + DATA_CENTER_BIT;

    /**
     * 数据中心
     */
    private long dataCenterId;
    /**
     * 机器标识
     */
    private long machineId;
    /**
     * 序列号
     */
    private long sequence = 0L;
    /**
     * 上一次时间戳
     */
    private long lastTimeStamp = -1L;


    public SnowFlake(long dataCenterId,long machineId){
        if (dataCenterId>MAX_DATA_CENTER_NUM || dataCenterId<0){
            throw new IllegalArgumentException("DataCenterId can't be greater than MAX_DATA_CENTER_NUM or less than 0!");
        }
        if (machineId>MAX_MACHINE_NUM || machineId<0){
            throw new IllegalArgumentException("machineId can't be greater than MAX_MACHINE_NUM or less than 0!");
        }

        this.dataCenterId = dataCenterId;
        this.machineId = machineId;
    }


    /**
     * 产生下一个ID
     */
    public synchronized long nextId(){
        long currTimeStamp = getNewTimeStamp();
        if (currTimeStamp<lastTimeStamp){
            throw new RuntimeException("Clock moved backwards.  Refusing to generate id");
        }

        if (currTimeStamp == lastTimeStamp ){
            //相同毫秒内，序列号自增
            sequence = (sequence + 1)&MAX_SEQUENCE;
            //如果同意毫秒内序列号已经达到最大
            if (sequence ==0L){
                currTimeStamp = getNextMill();
            }
        }else{
            sequence = 0;
        }
        lastTimeStamp = currTimeStamp;
        return (currTimeStamp - START_TIMESTAMP)<< TIMESTAMP_LEFT
                | dataCenterId << DATA_CENTER_LEFT
                | machineId << MACHINE_LEFT
                | sequence;
    }

    private long getNewTimeStamp() {
        return System.currentTimeMillis();
    }

    private long getNextMill() {
        long mill = getNewTimeStamp();
        while (mill <= lastTimeStamp) {
            mill = getNewTimeStamp();
        }
        return mill;
    }


    public static void main(String[] args) {
       /* System.out.println(-1L << SEQUENCE_BIT);
        System.out.println(-1L);
        System.out.println(-1L ^ (-1L << SEQUENCE_BIT));*/

        SnowFlake snowFlake = new SnowFlake(2,3);
        for (int i = 0; i < (1<<4); i++) {
            //十进制
            long id = snowFlake.nextId();
            //62进制
            String convertedNumStr = NumericConvertUtils.toOtherNumberSystem(id,62);
            //10进制转化为62进制
            System.out.println("10进制：" + id + "  62进制短地址:" + convertedNumStr);
            //TODO 执行具体的存储操作，可以存放在Redis等中
            //62进制转化为10进制
            System.out.println("62进制短地址：" + convertedNumStr + "  10进制:" + NumericConvertUtils.toDecimalNumber(convertedNumStr, 62));
            System.out.println();
        }

    }

}

































