package chapter01_basic.lambda;

import java.util.Arrays;
import java.util.function.Consumer;

/**
 * 消费型接口，consumer接口，消费一个对象
 *  consumer接口的默认方法
 * @author Administrator
 * @version 1.0
 * @date 2021/01/25 14:33
 */
public class ConsumerDemo {

    public static void main(String[] args) {
        Upper("adfasf", (s) ->
                System.out.println(s.toUpperCase()));

        reverse((String s) -> {
            String s1 = new StringBuffer(s).reverse().toString();
            System.out.println(s1);
        },"abcdef");

        andThenDemo((String s) ->{
            String s1 = s.toUpperCase();
            System.out.println(s1);
        },(String s) -> {
            System.out.println(s);
        }, "this is a test");

    }

    public static void Upper(String s, Consumer<String> consumer) {
        consumer.accept(s);
    }

    public static void reverse(Consumer<String> consumer, String s) {
        consumer.accept(s);
    }

    public static void andThenDemo(Consumer<String> con1, Consumer<String> con2, String s) {
        con1.accept(s);
        con2.accept(s);

        con1.andThen(con2).accept(s);
    }

}
