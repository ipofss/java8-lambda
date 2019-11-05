package com.wbs.java8lambda.chapter5;

import com.wbs.java8lambda.entity.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * TODO
 *
 * @author: wangbingshuai
 * @create: 2019-11-01 16:07
 **/
public class NumericStreams {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 4, 5, 1, 2);
        Arrays.stream(numbers.toArray()).forEach(System.out::println);

        int calories = Dish.menu.stream()
                .mapToInt(Dish::getCalories)
                .sum();
        System.out.println("Number of calories:" + calories);

        OptionalInt maxCalories = Dish.menu.stream()
                .mapToInt(Dish::getCalories)
                .max();
        int max;
        if (maxCalories.isPresent()) {
            max = maxCalories.getAsInt();
        } else {
            max = 1;
        }
        System.out.println(max);

        IntStream evenNumbers = IntStream.rangeClosed(1, 100)
                .filter(n -> n % 2 == 0);
        System.out.println(evenNumbers.count());

        Stream<int[]> pythagoreanTriples = IntStream.rangeClosed(1, 100).boxed()
                .flatMap(a -> IntStream.rangeClosed(a, 100)
                        .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                        .boxed()
                        .map(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)}));
        pythagoreanTriples.forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2]));
    }
}
