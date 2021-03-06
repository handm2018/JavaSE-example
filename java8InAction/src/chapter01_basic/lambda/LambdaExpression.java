package chapter01_basic.lambda;

import chapter01_basic.action.Solutions;
import chapter01_basic.entity.Apple;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * TODO
 *
 * @author Administrator
 * @version 1.0
 * @date 2021/1/19 17:07
 */
public class LambdaExpression {

    public static void main(String[] args) {
        List<Apple> apples = Arrays.asList(new Apple("green", 126), new Apple("yellow", 150),
                new Apple("red", 142), new Apple("black", 109));

        Comparator<Apple> comparator = new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight() - o2.getWeight();
            }
        };

        Comparator<Apple> comparator1 = (o1, o2) -> o1.getWeight() - o2.getWeight();

        System.out.println("before:  " + apples);
//        apples.sort(comparator);
        apples.sort(comparator1);
        System.out.println("after:  " + apples);

        Function<String, Integer> function = String::length;

        Predicate<Apple> filter = (Apple a) -> a.getColor().equals("green");
    }

}
