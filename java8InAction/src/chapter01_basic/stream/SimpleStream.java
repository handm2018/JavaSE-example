package chapter01_basic.stream;

import chapter01_basic.entity.Dish;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * TODO
 *
 * @author Administrator
 * @version 1.0
 * @date 2021/01/21 16:58
 */
public class SimpleStream {
    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT), new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT), new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER), new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER), new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH));

        List<String> namesByCollections = getDishNamesByCollections(menu);
        System.out.println(namesByCollections);
        List<String> namesByStream = getDishNamesByStream(menu);
        System.out.println(namesByStream);

        Stream<Dish> stream = menu.stream();
        stream.forEach(System.out::println);
        stream.forEach(System.out::println);
    }

    private static List<String> getDishNamesByStream(List<Dish> dishes) {
        List<String> list = dishes.stream().filter(dish -> dish.getCalories() < 400)
                .sorted(Comparator.comparing(Dish::getCalories)).map(Dish::getName).collect(Collectors.toList());
        return list;
    }

    private static List<String> getDishNamesByCollections(List<Dish> dishes) {
        List<Dish> lowCalories = new ArrayList<>();
        for (Dish dish : dishes) {
            if (dish.getCalories() < 400) {
                lowCalories.add(dish);
            }
        }
        Collections.sort(lowCalories, (d1, d2) -> Integer.compare(d1.getCalories(), d2.getCalories()));
        List<String> dishNames = new ArrayList<>();
        for (Dish lowCalory : lowCalories) {
            dishNames.add(lowCalory.getName());
        }
        return dishNames;
    }
}
