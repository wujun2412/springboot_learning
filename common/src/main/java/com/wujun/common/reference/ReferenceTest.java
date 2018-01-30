package com.wujun.common.reference;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;

/**
 * @author wujun
 * @description
 * 在Java层面，一共有四种引用：强引用、软引用、弱引用、虚引用，从名字也可以发现，这几种引用的生命周期由强到弱。
 * @date 18/1/30.
 */
public class ReferenceTest {

    public static void main(String[] args) {
        //软引用
        softReference();
        //弱引用
        weakReference();

        ByteBuffer.allocateDirect(11024);
    }



    public static void softReference(){
        Object reference = new ReferenceTest();
        System.out.println(reference);
        Reference root = new SoftReference(reference);
        reference = null;
        System.gc();
        System.out.println(root.get());
    }

    public static void weakReference(){
        final ReferenceQueue queue = new ReferenceQueue();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        Reference reference = queue.remove();
                        System.out.println(reference+"回收了");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        Object reference = new ReferenceTest();
        System.out.println(reference);
        Reference root = new WeakReference(reference,queue);
        reference = null;
        System.gc();
        System.out.println(root.get());
    }
}


