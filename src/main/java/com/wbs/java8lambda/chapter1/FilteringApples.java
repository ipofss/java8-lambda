package com.wbs.java8lambda.chapter1;

import com.wbs.java8lambda.entity.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * 第一章示例
 *
 * @author: wangbingshuai
 * @create: 2019-10-28 15:06
 **/
public class FilteringApples {
    public static void main(String[] args) {
        List<Apple> apples = Arrays.asList(new Apple(80, "green"),
                new Apple(155, "green"),
                new Apple(120, "red"));

        List<Apple> apples1 = filterGreenApples(apples);
        System.out.println(apples1);

        List<Apple> apples2 = filterHeavyApples(apples);
        System.out.println(apples2);

        List<Apple> greenApples = filterApples(apples, FilteringApples::isGreenApple);
        System.out.println(greenApples);

        List<Apple> heavyApples = filterApples(apples, FilteringApples::isHeavyApple);
        System.out.println(heavyApples);

        List<Apple> greenApples2 = filterApples(apples, (Apple a) -> "green".equals(a.getColor()));
        System.out.println(greenApples2);

        List<Apple> heavyApples2 = filterApples(apples, a -> a.getWeight() > 150);
        System.out.println(heavyApples2);

        List<Apple> weirdApples = filterApples(apples, a -> a.getWeight() < 80 || "brown".equals(a.getColor()));
        System.out.println(weirdApples);
    }

    private static boolean isGreenApple(Apple apple) {
        return "green".equals(apple.getColor());
    }

    private static boolean isHeavyApple(Apple apple) {
        return apple.getWeight() > 150;
    }

    private static List<Apple> filterApples(List<Apple> list, Predicate<Apple> p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : list) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    private static List<Apple> filterGreenApples(List<Apple> list) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : list) {
            if ("green".equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    private static List<Apple> filterHeavyApples(List<Apple> list) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : list) {
            if (apple.getWeight() > 150) {
                result.add(apple);
            }
        }
        return result;
    }
}
