package io.stream;

import java.io.*;

/**
 * 字节流拷贝视频
 *
 * @author Administrator
 * @version 1.0
 * @date 2021/03/01 11:35
 */
public class CopyVideo {
    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        System.out.println("开始复制：" + start);
//        method1();
        method2();
        long end = System.currentTimeMillis();
        System.out.println("复制结束,耗时：" + (start - end));
    }

    private static void method2() throws IOException {
        FileInputStream fis = new FileInputStream("D://mv.mp4");
        FileOutputStream fos = new FileOutputStream("E://b.mp4");
        int b;
        byte[] bytes = new byte[8192];
        while ((b = fis.read(bytes)) != -1) {
            fos.write(bytes, 0, b);
        }
        fos.flush();
        fos.close();
        fis.close();
    }


    private static void method1() throws IOException {
        FileInputStream fis = new FileInputStream("D://mv.mp4");
        BufferedInputStream bis = new BufferedInputStream(fis);
        FileOutputStream fos = new FileOutputStream("E://b.mp4");
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        int b;
        byte[] bytes = new byte[8192];
        while ((b = bis.read(bytes)) != -1) {
            bos.write(bytes, 0, b);
        }
        bos.flush();
        fos.close();
        fis.close();
        bos.close();
        bis.close();
    }

}
