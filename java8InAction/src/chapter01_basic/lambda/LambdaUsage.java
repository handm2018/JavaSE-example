package chapter01_basic.lambda;

import chapter01_basic.entity.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

/**
 * TODO
 *
 * @author Administrator
 * @version 1.0
 * @date 2021/1/20 10:08
 */
public class LambdaUsage {

    public static List<Apple> filterApples(List<Apple> apples, Predicate<Apple> predicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : apples) {
            if (predicate.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterApplesByWeight(List<Apple> apples, IntPredicate predicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : apples) {
            if (predicate.test(apple.getWeight())) {
                result.add(apple);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + ":   start");
            }
        };
        process(runnable);

        Runnable runnable1 = () -> System.out.println(Thread.currentThread().getName() + ":   start");
        process(runnable1);
        process(() -> System.out.println(Thread.currentThread().getName() + ":   start"));

        List<Apple> apples = Arrays.asList(new Apple("green", 120), new Apple("yellow", 139), new Apple("green", 140));
        List<Apple> yellow = filterApples(apples, (apple) -> apple.getColor().equals("yellow"));
        System.out.println(yellow);

        List<Apple> applesByWeight = filterApplesByWeight(apples, (weight) -> weight > 100);
        System.out.println(applesByWeight);

        List<Apple> applesByPredicate = filterApplesByPredicate(apples, (color, weight) -> color.equals("green") && weight > 130);
        System.out.println(applesByPredicate);

        System.out.println("======================Consumer==========================");
        simpleTestConsumer(apples, apple -> {
            System.out.println(apple);
        });
        System.out.println("======================BiConsumer==========================");
        testConsumer(apples, (color, weight) -> System.out.println(color + weight));
        System.out.println("======================Function==========================");
        String green = testFunction(new Apple("green", 125), (apple) -> apple.getColor());
        System.out.println(green);

        IntFunction<String> intFunction = (i) -> i + 500 + "ggg";
        String apply = intFunction.apply(200);
        System.out.println(apply);

        System.out.println("======================BiFunction==========================");
        Apple red = testBiFunction("red", 150, (color, weight) -> new Apple(color, weight - 20));
        System.out.println(red);

        System.out.println("======================Supplier==========================");
        Apple testSupplier = testSupplier(() -> new Apple("green", 100));
        System.out.println(testSupplier);

    }

    public static Apple testSupplier(Supplier<Apple> supplier) {
        return supplier.get();
    }

    public static Apple testBiFunction(String color, Integer weight, BiFunction<String, Integer, Apple> biFunction) {
        return biFunction.apply(color, weight);
    }

    public static String testFunction(Apple apple, Function<Apple, String> function) {
        return function.apply(apple);
    }

    public static void testConsumer(List<Apple> apples, BiConsumer<String, Integer> consumer) {
        for (Apple apple : apples) {
            consumer.accept(apple.getColor(), apple.getWeight());
        }
    }

    public static void simpleTestConsumer(List<Apple> apples, Consumer<Apple> appleConsumer) {
        for (Apple apple : apples) {
            appleConsumer.accept(apple);
        }
    }

    public static List<Apple> filterApplesByPredicate(List<Apple> apples, BiPredicate<String, Integer> predicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : apples) {
            if (predicate.test(apple.getColor(), apple.getWeight())) {
                result.add(apple);
            }
        }
        return result;
    }

    public static void process(Runnable runnable) {
        new Thread(runnable).start();
    }
}
