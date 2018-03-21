package com.wujun.common.test.serialize;

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
public class SerializableTest1 {

    public static void main(String[] args) {
        User user = new User();
        user.setName("test");
        user.setAge(11);
        System.out.println(user);

        //write obj to file
        try(FileOutputStream fos = new FileOutputStream("tempFile"); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(user);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(FileInputStream fis = new FileInputStream("tempFile"); ObjectInputStream ois = new ObjectInputStream(fis)){
            User u1 = (User) ois.readObject();
            System.out.println(u1);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
