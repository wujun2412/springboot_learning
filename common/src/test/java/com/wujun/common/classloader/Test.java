package com.wujun.common.classloader;

/**
 * @author wujun
 * @description
 * @date 19/5/17.
 */
public class Test {

    public static void main(String[] args) {
        ClassLoader loader = Test.class.getClassLoader();
        while (loader != null){
            System.out.println(loader);
            loader = loader.getParent();
        }
    }
}
