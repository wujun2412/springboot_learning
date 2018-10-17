package com.wujun.common.utils;

import java.util.List;

/**
 * @Auther: Jun.Wu
 * @Date: 2018-08-15 10:27
 * @Description:
 */
public class ListUtil {

    public ListUtil() {
    }

    public static boolean isEmpty(List<?> list) {
        return list == null || list.size() == 0;
    }
}
