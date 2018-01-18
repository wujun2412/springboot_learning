package com.wujun.socket.simple;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author wujun
 * @description
 * @date 18/1/18.
 */
public class Server {
    private int port = 10088;
    private ServerSocket serverSocket;

    public Server() throws Exception {
        serverSocket = new ServerSocket(port,3);
        System.out.println("服务器启动!");
    }

    public void service(){
        while (true) {
            Socket socket = null;

            try {
                socket = serverSocket.accept();
                System.out.println("New connection accepted " + socket.getInetAddress() + ":" + socket.getPort());
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (socket != null) {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Server server = new Server();
        //Thread.sleep(600*1000);
        server.service();
    }

}
