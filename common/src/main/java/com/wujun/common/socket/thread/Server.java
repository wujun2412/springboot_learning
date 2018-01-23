package com.wujun.common.socket.thread;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author wujun
 * @description 基于TCP协议的Socket通信
 * @date 18/1/18.
 */
public class Server {

    public static void main(String[] args) {
        //1.创建一个服务器端Socket,即ServerSocket,指定绑定的端口，并监听此端口
        try {
            ServerSocket serverSocket = new ServerSocket(10099);
            Socket socket = null;
            //记录客户端连接数量
            int count = 0;
            System.out.println("***服务器即将启动，等待客户端的连接***");
            while (true){
                //调用accept()方法开始监听，等待客户端的连接
                socket = serverSocket.accept();
                //创建一个新的线程，处理客户端请求
                Thread serverThread = new Thread(new ServerThread(socket));
                //启动线程
                serverThread.start();
                count ++;
                System.out.println("客户端连接数量："+count);
                InetAddress inetAddress = socket.getInetAddress();
                System.out.println("当前客户端的IP:"+inetAddress.getHostAddress());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
