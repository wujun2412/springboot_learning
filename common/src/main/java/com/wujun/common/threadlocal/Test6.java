package com.wujun.common.threadlocal;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wujun
 * @description
 * @date 18/4/11.
 */
public class Test6 {

    public static void main(String[] args) {
        /*String resolvedName = "sdf";
        while (resolvedName != null);

        System.out.println(resolvedName);*/
        List<BigDecimal> list = new ArrayList<>(8);
        list.add(new BigDecimal(2));
        list.add(new BigDecimal(3));

        BigDecimal b1 = new BigDecimal(2);
        System.out.println(list.contains(b1));

    }
}
