package io.stream;

import java.io.*;

/**
 * BufferedInputStream,BufferedOutputStream
 *
 * @author Administrator
 * @version 1.0
 * @date 2021/02/26 14:20
 */
public class BufferStreamDemo {
    public static void main(String[] args) throws IOException {
        // 输入流
        FileInputStream fis = new FileInputStream("a.txt");
        BufferedInputStream bis = new BufferedInputStream(fis);
        byte[] bytes = new byte[8192];
        int len;
        while ((len = bis.read(bytes)) != -1) {
            String msg = new String(bytes, 0, len);
            System.out.println(msg);
        }
        bis.close();
        fis.close();

        // 输出流
        FileOutputStream fos = new FileOutputStream("a.txt");
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        bos.write("疏影横斜水清浅，暗香浮动月黄昏".getBytes());
        bos.flush();
        bos.close();
        fos.close();
    }
}
