package com.wbs.java8lambda.chapter3;

import com.wbs.java8lambda.entity.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * TODO
 *
 * @author: wangbingshuai
 * @create: 2019-10-30 15:29
 **/
public class Lambdas {
    public static void main(String[] args) {
        Runnable r = () -> System.out.println("Hello!");
        r.run();

        List<Apple> list = Arrays.asList(new Apple(80, "green"),
                new Apple(155, "green"),
                new Apple(120, "red"));
        List<Apple> greenApples = filter(list, (Apple a) -> "green".equals(a.getColor()));
        System.out.println(greenApples);

        Comparator<Apple> c = (Apple o1, Apple o2) -> o1.getWeight().compareTo(o2.getWeight());
        list.sort(c);
        System.out.println(list);
    }

    private static List<Apple> filter(List<Apple> list, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : list) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }
}
