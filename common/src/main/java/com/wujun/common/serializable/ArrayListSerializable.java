package com.wujun.common.serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wujun
 * @description
 * @date 18/4/13.
 */
public class ArrayListSerializable {


    public static void main(String[] args) {
        List<String> list = new ArrayList<>(20);
        list.add("test");
        list.add("值");

        //序列化写入文件
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("/Users/wujun/Downloads/test.tmp"));
            outputStream.writeObject(list);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //读取序列化文件
        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("/Users/wujun/Downloads/test.tmp"));
            List readTest = (List) inputStream.readObject();
            System.out.println("读取序列化后的值："+readTest.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }



}
