package chapter01_basic.lambda;

import java.util.function.Function;

/**
 * 接收一个类型的参数，返回另一个类型的数据
 *
 * @author Administrator
 * @version 1.0
 * @date 2021/01/25 16:44
 */
public class FunctionDemo {

    public static void main(String[] args) {
        int i = applyTest("200", Integer::parseInt);
        System.out.println(i);
        applyDemo("280", Integer::parseInt, m -> String.valueOf(m + 300));
    }

    public static int applyTest(String s, Function<String, Integer> function) {
        return function.apply(s);
    }

    public static void applyDemo(String s, Function<String, Integer> fun1, Function<Integer, String> fun2) {
        String apply = fun1.andThen(fun2).apply(s);
        System.out.println(apply);
    }
}
