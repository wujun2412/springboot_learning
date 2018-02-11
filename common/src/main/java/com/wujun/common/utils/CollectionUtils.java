package com.wujun.common.utils;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author wujun
 * @description
 * @date 18/2/11.
 */
public class CollectionUtils {

    public CollectionUtils() {
    }

    public static boolean isEmpty(Collection coll) {
        return coll == null || coll.isEmpty();
    }

    public static boolean isNotEmpty(Collection coll) {
        return !isEmpty(coll);
    }

    public static <T> T getLast(List<T> list) {
        return isEmpty((Collection)list)?null:list.get(list.size() - 1);
    }

    public static boolean isEmpty(Map map) {
        return map == null || map.isEmpty();
    }

    public static boolean isNotEmpty(Map map) {
        return !isEmpty(map);
    }

}
