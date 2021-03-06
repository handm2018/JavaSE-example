package io.read;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * 字符流练习
 *
 * @author Administrator
 * @version 1.0
 * @date 2021/03/01 16:30
 */
public class Exercise {

    public static void main(String[] args) throws IOException {

//        exercise1();
        exercise2();
    }

    /**
     *  从文件中读取任意一行文字输出到控制台
     * @throws IOException
     */
    private static void exercise2() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("exercise.txt"));
        String line;
        ArrayList<String> ss = new ArrayList<>();
        while ((line = br.readLine()) != null) {
            ss.add(line);
        }
        br.close();

        Random random = new Random();
        //使用Random产生一个随机数，随机数的范围在：[0,集合的长度)
        int i = random.nextInt(ss.size());
        System.out.println(i);
        System.out.println(ss.get(i));
    }

    /**
     * 把文本文件中的数据读取到集合中，并遍历集合。要求：文件中每一行数据是一个集合元素
     *
     * @throws IOException
     */
    private static void exercise1() throws IOException {
        // 把文本文件中的数据读取到集合中，并遍历集合。要求：文件中每一行数据是一个集合元素
        BufferedReader br = new BufferedReader(new FileReader("exercise.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("exercise-copy.txt"));
        ArrayList<String> strings = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null) {
            strings.add(line);
            bw.write(line);
            bw.newLine();
            bw.flush();
        }
        bw.close();
        br.close();
        System.out.println("白马篇-曹植");
        strings.forEach(System.out::println);
    }


}
