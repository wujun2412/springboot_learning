package com.wujun.socket.thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author wujun
 * @description
 * @date 18/1/18.
 */
public class Client {

    public static void main(String[] args) {
        try {
            //1.创建客户端Socket,指定服务器地址和端口
            Socket socket = new Socket("127.0.0.1",10099);
            //2.获取输出流，向服务器端发送信息
            OutputStream os = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(os);
            pw.write("用户名：wujun,密码：123");
            pw.flush();
            //3.关闭输出流
            socket.shutdownOutput();
            //4.获取输入流，并读取服务端响应信息
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String str = null;
            while ((str=br.readLine())!=null){
                System.out.println("我是客户端，服务器说："+str);
            }
            //关闭资源
            br.close();
            isr.close();
            is.close();
            pw.close();
            os.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
