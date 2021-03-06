package chapter01_basic.entity;

/**
 * TODO
 * 菜实体
 *
 * @author Administrator
 * @version 1.0
 * @date 2021/01/21 16:56
 */
public class Dish {
    /* 菜名 */
    private final String name;
    /* 是否是素食 */
    private final boolean vegetarian;
    /* 卡路里 */
    private final int calories;
    /* 菜的类型 */
    private final Type type;

    public Dish(String name, boolean vegetarian, int calories, Type type) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.type = type;
    }


    public String getName() {
        return name;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public int getCalories() {
        return calories;
    }

    public Type getType() {
        return type;
    }

    public enum Type {MEAT, FISH, OTHER}


    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                ", vegetarian=" + vegetarian +
                ", calories=" + calories +
                ", type=" + type +
                '}';
    }

}
