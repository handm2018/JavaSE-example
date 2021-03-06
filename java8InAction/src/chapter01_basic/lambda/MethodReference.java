package chapter01_basic.lambda;

import java.util.function.Consumer;

/**
 * TODO
 *
 * @author Administrator
 * @version 1.0
 * @date 2021/1/21 14:15
 */
public class MethodReference {
    public static void main(String[] args) {
        Consumer<String> consumer = (s) -> System.out.println(s);
        useConsumer(consumer,"test consumer");

        useConsumer(System.out::println,"test method reference");
    }

    public static <T> void useConsumer(Consumer<T> consumer, T t) {
        consumer.accept(t);
        consumer.accept(t);
    }

}
