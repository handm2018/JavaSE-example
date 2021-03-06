package net.tcp;


import javax.annotation.Resource;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TCP服务端demo
 *
 * @author Administrator
 * @version 1.0
 * @date 2021/02/23 15:38
 */
public class TCPServer {

    public static void main(String[] args) throws IOException{

//        server1();

        ServerSocket serverSocket = new ServerSocket(9002);
        Socket accept = serverSocket.accept();
        InputStream inputStream = accept.getInputStream();
        byte[] bytes = new byte[1024];
        int len;
        FileOutputStream fos = new FileOutputStream(new File("sr.jpg"));
        while ((len = inputStream.read(bytes)) != -1) {
            fos.write(bytes);
        }

        OutputStream outputStream = accept.getOutputStream();
        outputStream.write("接收到图片了".getBytes());

        fos.close();
        accept.close();
        serverSocket.close();
    }

    private static void server1() {
        ServerSocket serverSocket = null;
        Socket accept = null;
        InputStream inputStream = null;
        OutputStream outputStream = null;

        try {
            serverSocket = new ServerSocket(9001);
            accept = serverSocket.accept();
            inputStream = accept.getInputStream();
            byte[] bytes = new byte[1024];
            int len;
            while ((len = inputStream.read(bytes)) != -1) {
                String string = new String(bytes, 0, len);
                System.out.print(string);
            }

            outputStream = accept.getOutputStream();
            outputStream.write("服务端收到消息了，返回给客户端消息".getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert inputStream != null;
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                accept.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                assert outputStream != null;
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
