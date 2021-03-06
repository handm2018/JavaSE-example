package io.read;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * 字符流
 *
 * @author Administrator
 * @version 1.0
 * @date 2021/03/01 11:27
 */
public class FileWriteAndFileRead {

    public static void main(String[] args) throws IOException {
//        stringBytes();
//        demo1();
//        demo2();
        demo3();

    }

    /**
     * 缓冲字符流，特有方法，readLine() newLine()
     * @throws IOException
     */
    private static void demo3() throws IOException {
        BufferedReader bfr = new BufferedReader(new FileReader("a.txt"));
        BufferedWriter bfw = new BufferedWriter(new FileWriter("b.txt"));
        String line;
        while ((line = bfr.readLine()) != null) {
            System.out.println(line);
            bfw.write(line);
            bfw.newLine();
        }
        bfr.close();
        bfw.close();
    }

    /**
     * 字符输入输出流，
     * @throws IOException
     */
    private static void demo2() throws IOException {
        InputStreamReader isr = new InputStreamReader(new FileInputStream("a.txt"));
        int len;
        char[] chars = new char[1024];
        while ((len = isr.read(chars)) != -1) {
            String s = new String(chars, 0, len);
            System.out.println(s);
        }
        isr.close();

        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("a.txt"));
        osw.write("平凡才是唯一的答案");
        osw.close();
    }

    /**
     * 字符输入输出流，封装InputStreamReader OutputStreamWriter为更简单易用的FileReader FileWriter
     * @throws IOException
     */
    private static void demo1() throws IOException {
        FileWriter fw = new FileWriter("a.txt");
        fw.write("我曾拥有过的一切,转眼都飘散如烟");
        fw.flush();
        fw.close();

        FileReader fr = new FileReader("a.txt");
        int len;
        while ((len = fr.read()) != -1) {
            System.out.print((char) len);
        }
        fr.close();
    }

    /**
     * 中文占用：
     * UTF-8 3个字节
     * GBK   2个字节
     */
    private static void stringBytes() {
        String msg = "归来仍是少年";
        byte[] bytes = msg.getBytes(StandardCharsets.UTF_8);
        System.out.println(Arrays.toString(bytes));
        byte[] bytes1 = msg.getBytes(Charset.forName("gbk"));
        System.out.println(Arrays.toString(bytes1));
        System.out.println(new String(bytes, StandardCharsets.UTF_8));
        System.out.println(new String(bytes1, Charset.forName("gbk")));
    }

}
