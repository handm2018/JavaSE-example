package net.tcp;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * TCP客户端demo
 *
 * @author Administrator
 * @version 1.0
 * @date 2021/02/23 15:01
 */
public class TCPClient {

    public static void main(String[] args) throws IOException {
//        client1();

        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 9002);
        OutputStream outputStream = socket.getOutputStream();
        FileInputStream fis = new FileInputStream(new File("yuan.jpg"));
        byte[] bytes = new byte[1024];
        int len;
        while ((len = fis.read(bytes)) != -1) {
            outputStream.write(bytes);
        }
        socket.shutdownOutput();

        InputStream socketInputStream = socket.getInputStream();
        byte[] bytes1 = new byte[1024];
        int len1;
        while ((len1 = socketInputStream.read(bytes1)) != -1) {
            System.out.println(new String(bytes1, 0, len1));
        }

        fis.close();
        socket.close();

    }

    private static void client1() {
        Socket socket = null;
        OutputStream outputStream = null;
        try {
            socket = new Socket(InetAddress.getByName("127.0.0.1"), 9001);
            outputStream = socket.getOutputStream();
            outputStream.write("tcp客户端发送消息".getBytes());

            socket.shutdownOutput();
            InputStream inputStream = socket.getInputStream();
            byte[] bytes = new byte[1024];
            int len;
            while ((len = inputStream.read(bytes)) != -1) {
                System.out.print(new String(bytes, 0, len));
            }
            

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert outputStream != null;
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
