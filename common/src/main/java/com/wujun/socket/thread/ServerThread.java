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
 * @description 服务器线程处理类
 * @date 18/1/18.
 */
public class ServerThread implements Runnable {

    /**
     * 服务器线程处理和本线程相关的socket
     */
    Socket socket = null;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    /**
     * 线程执行，相应客户端请求
     */
    @Override
    public void run() {
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        OutputStream os = null;
        PrintWriter pw = null;
        try {
            is = socket.getInputStream();
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);
            String str = null;
            String result = null;
            while ((str = br.readLine()) != null) {
                result = str;
                System.out.println("服务端接收客户端请求：" + str);
            }
            //关闭输入流
            socket.shutdownInput();
            //获取输出流，响应客户端的请求
            os = socket.getOutputStream();
            pw = new PrintWriter(os);
            pw.write("服务端欢迎您：" + result);
            pw.flush();//调用flush()方法将缓冲输出
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                if (pw != null) {
                    pw.close();
                }
                if (os != null) {
                    os.close();
                }
                if (br!=null){
                    br.close();
                }
                if (isr!=null){
                    isr.close();
                }
                if (is!=null){
                    is.close();
                }
                if (socket!=null){
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
