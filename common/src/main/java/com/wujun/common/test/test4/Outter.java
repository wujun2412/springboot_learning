package com.wujun.common.test.test4;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author wujun
 * @description
 * @date 18/12/11.
 */
@Getter
@AllArgsConstructor
public final class Outter {
    private final String name;
    private String age;


    public static Inner newInner(final String name) {
        return new Inner(name);
    }

    @RequiredArgsConstructor(access = AccessLevel.PRIVATE)
    public static class Inner{
        private final String name;
        private String age;

        public Outter.Inner age(String age){
            this.age = age;
            return this;
        }

        public final Outter build(){
            return new Outter(name, age);
        }
    }
}
