package com.wbs.java8lambda.chapter5;

import com.wbs.java8lambda.chapter4.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * TODO
 *
 * @author: wangbingshuai
 * @create: 2019-10-31 20:30
 **/
public class Reducing {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 4, 5, 1, 2);
        Integer sum = numbers.stream()
                .reduce(0, (a, b) -> a + b);
        System.out.println(sum);

        Integer sum2 = numbers.stream().reduce(0, Integer::sum);
        System.out.println(sum2);

        Integer max = numbers.stream().reduce(0, (a, b) -> Integer.max(a, b));
        System.out.println(max);

        Optional<Integer> min = numbers.stream().reduce(Integer::min);
        min.ifPresent(System.out::println);

        Integer calories = Dish.menu.stream()
                .map(Dish::getCalories)
                .reduce(0, Integer::sum);
        System.out.println("Number of calories:" + calories);
    }
}
