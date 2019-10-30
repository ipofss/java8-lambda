package com.wbs.java8lambda.chapter4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * TODO
 *
 * @author: wangbingshuai
 * @create: 2019-10-30 19:22
 **/
public class StreamBasic {
    public static void main(String[] args) {
        getLowCaloricDishesNamesInJava7(Dish.menu).forEach(System.out::println);

        System.out.println("---");

        getLowCaloricDishesNamesInJava8(Dish.menu).forEach(System.out::println);
    }

    private static List<String> getLowCaloricDishesNamesInJava7(List<Dish> list) {
        List<Dish> lowCaloricDishes = new ArrayList<>();
        for (Dish dish : list) {
            if (dish.getCalories() < 400) {
                lowCaloricDishes.add(dish);
            }
        }
        Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
            @Override
            public int compare(Dish o1, Dish o2) {
                return Integer.compare(o1.getCalories(), o2.getCalories());
            }
        });
        List<String> lowCaloricDishesNames = new ArrayList<>();
        for (Dish dish : lowCaloricDishes) {
            lowCaloricDishesNames.add(dish.getName());
        }
        return lowCaloricDishesNames;
    }

    private static List<String> getLowCaloricDishesNamesInJava8(List<Dish> list) {
        return list.stream()
                .filter(d -> d.getCalories() < 400)
                .sorted(Comparator.comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(Collectors.toList());
    }
}
