package com.wbs.java8lambda.chapter2;

import com.wbs.java8lambda.entity.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 第二章示例
 *
 * @author: wangbingshuai
 * @create: 2019-10-28 16:48
 **/
public class FilteringApples {
    public static void main(String[] args) {
        List<Apple> appleList = Arrays.asList(new Apple(80, "green"),
                new Apple(155, "green"),
                new Apple(120, "red"));

        List<Apple> greenApples = filterAppleByColor(appleList, "green");
        System.out.println(greenApples);

        List<Apple> redApples = filterAppleByColor(appleList, "red");
        System.out.println(redApples);

        List<Apple> greenApples2 = filter(appleList, new AppleColorPredicate());
        System.out.println(greenApples2);

        List<Apple> heavyApples = filter(appleList, new AppleWeightPredicate());
        System.out.println(heavyApples);

        List<Apple> redAndHeavyApples = filter(appleList, new AppleRedAndHeavyPredicate());
        System.out.println(redAndHeavyApples);

        List<Apple> redApples2 = filter(appleList, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return apple.getColor().equals("red");
            }
        });
        System.out.println(redApples2);
    }

    private static List<Apple> filterAppleByColor(List<Apple> list, String color) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : list) {
            if (apple.getColor().equals(color)) {
                result.add(apple);
            }
        }
        return result;
    }

    private static List<Apple> filter(List<Apple> list, ApplePredicate predicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : list) {
            if (predicate.test(apple)) {
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

    private static List<Apple> filterApplesByWeight(List<Apple> list, int weight) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : list) {
            if (apple.getWeight() > weight) {
                result.add(apple);
            }
        }
        return result;
    }
}
