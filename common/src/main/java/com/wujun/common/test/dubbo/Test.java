package com.wujun.common.test.dubbo;

import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.alibaba.dubbo.rpc.Filter;

/**
 * @author wujun
 * @description
 * @date 18/3/14.
 */
public class Test {

    public static void main(String[] args) {
        ExtensionLoader<Filter> extensionLoader = ExtensionLoader.getExtensionLoader(Filter.class);
        System.out.println("");
 }

}
