package com.wujun.common.serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author wujun
 * @description
 * @date 18/4/13.
 */
public class TestSerializable implements Serializable {

    private static final long serialVersionUID = -126245237201812141L;
    private transient int num;
    private Test test;

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    private void writeObject(ObjectOutputStream os) throws IOException {
        os.defaultWriteObject();
        os.writeObject(num);
        System.out.println("writeObject of "+this.getClass().getName());
    }

    private void readObject(ObjectInputStream is) throws IOException, ClassNotFoundException {
        is.defaultReadObject();
        num = (int) is.readObject();
        System.out.println("readObject of "+this.getClass().getName());
    }

    public static void main(String[] args) {
        TestSerializable test = new TestSerializable();
        test.setNum(20);
        System.out.println("序列化前的值："+test.getNum());
        Test test2 = new Test();
        test.setTest(test2);

        //序列化写入文件
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("/Users/wujun/Downloads/test.tmp"));
            outputStream.writeObject(test);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //读取序列化文件
        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("/Users/wujun/Downloads/test.tmp"));
            TestSerializable readTest = (TestSerializable) inputStream.readObject();
            System.out.println("读取序列化后的值："+readTest.getNum());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}
