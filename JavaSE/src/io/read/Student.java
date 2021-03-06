package io.read;

/**
 * 实体类
 *
 * @author Administrator
 * @version 1.0
 * @date 2021/03/01 17:21
 */
public class Student {

    public Student() {
    }

    public Student(String name, int chinese, int english, int math) {
        this.name = name;
        this.chinese = chinese;
        this.english = english;
        this.math = math;
    }

    private String name;

    private int chinese;

    private int english;

    private int math;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getChinese() {
        return chinese;
    }

    public void setChinese(int chinese) {
        this.chinese = chinese;
    }

    public int getEnglish() {
        return english;
    }

    public void setEnglish(int english) {
        this.english = english;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }


    public int getSum() {
        return this.chinese + this.english + this.math;
    }

}
