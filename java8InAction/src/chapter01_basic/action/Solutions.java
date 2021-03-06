package chapter01_basic.action;

import chapter01_basic.entity.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 需求解决方案
 *
 * @author Administrator
 * @version 1.0
 * @date 2020/12/24 11:19
 */
public class Solutions {

    public static void main(String[] args) {
        // 1. 普通的解决方案
        List<Apple> apples = Arrays.asList(new Apple("green", 126), new Apple("yellow", 150),
                new Apple("red", 142), new Apple("black", 109));
        List<Apple> greenApple = filterGreenApple(apples);
        System.out.println("普通的解决方案：" + greenApple);

        // 2. 策略模式、内部类解决方案
        List<Apple> redAnd130Apples = filterApples(apples, new FilterRedAnd130Apple());
        System.out.println("策略模式：" + redAnd130Apples);

        List<Apple> filterApples = filterApples(apples, new AppleFilter() {
            @Override
            public boolean filter(Apple apple) {
                return apple.getWeight() < 150;
            }
        });
        System.out.println("策略模式+内部类解决方案：" + filterApples);

        List<Apple> greenList = filterApples(apples, (Apple apple) -> {
            return apple.getColor().equals("green");
        });
        System.out.println("lambda表达式：" + greenList);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });
        thread.start();

        new Thread(()->System.out.println(Thread.currentThread().getName())).start();
    }



    @FunctionalInterface
    public interface AppleFilter {
        boolean filter(Apple apple);
    }

    static class FilterRedAnd130Apple implements AppleFilter {
        @Override
        public boolean filter(Apple apple) {
            return apple.getColor().equals("red") && apple.getWeight() > 130;
        }
    }

    public static List<Apple> filterApples(List<Apple> apples, AppleFilter filter) {
        ArrayList<Apple> list = new ArrayList<>();
        for (Apple apple : apples) {
            if (filter.filter(apple)) {
                list.add(apple);
            }
        }
        return list;
    }

    /**
     * 筛选绿苹果
     *
     * @param apples
     * @return
     */
    public static List<Apple> filterGreenApple(List<Apple> apples) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : apples) {
            if ("green".equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }


}
