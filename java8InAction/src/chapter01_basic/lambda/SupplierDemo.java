package chapter01_basic.lambda;

import java.util.function.Supplier;

/**
 * 生成型接口 supplier接口  生成一个对象
 *
 * @author Administrator
 * @version 1.0
 * @date 2021/01/25 14:22
 */
public class SupplierDemo {

    public static String getString(Supplier<String> supplier) {
        return supplier.get();
    }

    public static void main(String[] args) {
        String test = getString(() -> {
            return "this is a test";
        });
        String string = getString(() -> "simple test");
        System.out.println(string);
        System.out.println(test);

        int[] arr = {15, 23, 45, 36, 10, 58, 99};
        int maxValue = getInt(() -> {
            int max = arr[0];
            for (int i : arr) {
                if (i > max) {
                    max = i;
                }
            }
            return max;
        });
        System.out.println("数组的最大值是：" + maxValue);
    }

    public static int getInt(Supplier<Integer> supplier) {
        return supplier.get();
    }
}
