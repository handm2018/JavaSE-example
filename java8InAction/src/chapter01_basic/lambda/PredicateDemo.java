package chapter01_basic.lambda;

import java.util.ArrayList;
import java.util.function.Predicate;

/**
 * 判断数据
 *
 * @author Administrator
 * @version 1.0
 * @date 2021/01/25 15:30
 */
public class PredicateDemo {

    public static void main(String[] args) {
        boolean b = checkString("hello", (String s) -> {
            return s.length() > 8;
        });
        checkString("hello", (s) -> s.length() > 8);
        System.out.println(b);

        boolean helloworld = checkString("helloworld", (s) -> s.length() > 8, (s) -> s.length() < 20);
        System.out.println(helloworld);

        String[] arr = {"andy,35", "adu,42", "long,47", "jack,23"};
        ArrayList<String> name = checkName(arr, s -> s.split(",")[0].length() > 3, s -> Integer.parseInt(s.split(",")[1]) < 25);
        System.out.println(name);

    }


    public static boolean checkString(String s, Predicate<String> pre1, Predicate<String> pre2) {
        boolean b1 = pre1.test(s);
        boolean b2 = pre2.test(s);
//        return b1 && b2;
        // return pre1.or(pre2).test(s)
        return pre1.and(pre2).test(s);

    }

    public static ArrayList<String> checkName(String[] arr, Predicate<String> pre1, Predicate<String> pre2) {
        ArrayList<String> result = new ArrayList<>();
        for (String s : arr) {
            boolean test = pre1.and(pre2).test(s);
            if (test) {
                result.add(s);
            }
        }
        return result;
    }


    public static boolean checkString(String s, Predicate<String> predicate) {
//        return predicate.test(s);
        return predicate.negate().test(s);
    }

}
