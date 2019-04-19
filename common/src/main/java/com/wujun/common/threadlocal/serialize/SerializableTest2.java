package com.wujun.common.threadlocal.serialize;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author wujun
 * @description
 * @date 18/3/21.
 */
public class SerializableTest2 {

    public static void main(String[] args) {
        User2 user = new User2();
        user.setName("test");
        user.setAge(22);
        System.out.println(user);

        try(FileOutputStream fos = new FileOutputStream("tempFile2"); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
             oos.writeObject(user);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(FileInputStream fis = new FileInputStream("tempFile2"); ObjectInputStream ois = new ObjectInputStream(fis)) {
            User2 u2 = (User2) ois.readObject();
            System.out.println(u2);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
