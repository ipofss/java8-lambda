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
 * @create: 2019-10-30 15:11
 **/
public class Sorting {
    public static void main(String[] args) {
        List<Apple> list = new ArrayList<>();
        list.addAll(Arrays.asList(new Apple(80, "green"),
                new Apple(155, "green"),
                new Apple(120, "red")));

        list.sort(new AppleComparator());
        System.out.println(list);

        list.set(1, new Apple(30, "green"));
        list.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight().compareTo(o2.getWeight());
            }
        });
        System.out.println(list);

        list.set(1, new Apple(20, "red"));
        list.sort((o1, o2) -> o1.getWeight().compareTo(o2.getWeight()));
        System.out.println(list);

        list.set(1, new Apple(10, "red"));
        list.sort(Comparator.comparing(Apple::getWeight));
        System.out.println(list);
    }
}
