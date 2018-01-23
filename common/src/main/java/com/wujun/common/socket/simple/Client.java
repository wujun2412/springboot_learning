package com.wujun.common.socket.simple;

import java.net.Socket;

/**
 * @author wujun
 * @description
 * @date 18/1/18.
 */
public class Client {

    public static void main(String[] args) throws Exception {
        final int length = 100;
        String host = "127.0.0.1";
        int port = 10088;
        Socket[] sockets = new Socket[length];
        for (int i =0 ;i<length;i++){
            sockets[i]= new Socket(host,port);
            System.out.println("第"+(i+1)+"次连接成功!");
        }
        Thread.sleep(3000);
        for (Socket socket :sockets){
            socket.close();
        }
    }

}
