package io.read;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 练习2：- 键盘录入5个学生信息(姓名,语文成绩,数学成绩,英语成绩)。要求按照成绩总分从高到低写入文本文件
 *      - 格式：姓名,语文成绩,数学成绩,英语成绩  举例：林青霞,98,99,100
 *
 * @author Administrator
 * @version 1.0
 * @date 2021/03/01 17:20
 */
public class Exercise02 {

    public static void main(String[] args) throws IOException {
//        method1();
        // Java8 stream lambda表达式
        ArrayList<Student> students = new ArrayList<>();
        scnner(students);
        List<Student> collect = students.stream().sorted(Comparator.comparingInt(Student::getSum).reversed().
                thenComparingInt(Student::getChinese).reversed().thenComparingInt(Student::getMath).reversed().
                thenComparing(Student::getName)).collect(Collectors.toList());
        write(collect);
    }


    /**
     * 传统方式
     * @throws IOException
     */
    private static void method1() throws IOException {
        TreeSet<Student> students = new TreeSet<>((o1, o2) -> {
            int i = o2.getSum() - o1.getSum();
            int i1 = i == 0 ? o2.getChinese() - o1.getChinese() : i;
            int i2 = i1 == 0 ? o2.getMath() - o1.getMath() : i1;
            return i2 == 0 ? o2.getName().compareTo(o1.getName()) : i2;
        });
        scnner(students);
        write(students);
    }

    /**
     * 按照格式写入到文件
     * @param collect
     * @throws IOException
     */
    private static void write(Collection<Student> collect) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("exercise02.txt"));
        bw.write("姓名，语文，数学，英语，总分");
        for (Student student : collect) {
            StringJoiner sj = new StringJoiner("，");
            StringJoiner stringJoiner = sj.add(student.getName()).add(String.valueOf(student.getChinese()))
                    .add(String.valueOf(student.getMath())).add(String.valueOf(student.getEnglish()))
                    .add(String.valueOf(student.getSum()));
            String s = stringJoiner.toString();
            bw.newLine();
            bw.write(s);
            bw.flush();
        }
        bw.close();
    }

    /**
     * 成绩录入
     * @param students
     */
    private static void scnner(Collection<Student> students) {
        for (int i = 0; i < 5; i++) {
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入第" + (i + 1) + "个学生信息");
            System.out.println("请输入姓名");
            String name = sc.nextLine();
            System.out.println("请输入语文成绩");
            int chinese = sc.nextInt();
            System.out.println("请输入数学成绩");
            int math = sc.nextInt();
            System.out.println("请输入英语成绩");
            int english = sc.nextInt();
            Student student = new Student(name, chinese, english, math);
            students.add(student);
        }
    }

}
