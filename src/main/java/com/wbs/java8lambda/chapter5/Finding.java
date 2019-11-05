package com.wbs.java8lambda.chapter5;

import com.wbs.java8lambda.entity.Dish;

import java.util.Optional;

/**
 * TODO
 *
 * @author: wangbingshuai
 * @create: 2019-10-31 19:53
 **/
public class Finding {
    public static void main(String[] args) {
        if (isVegetarianFriendMenu()) {
            System.out.println("Vegetarian friendly");
        }

        System.out.println(isHealthyMenu());
        System.out.println(isHealthyMenu2());

        Optional<Dish> dish = findVegetarianDish();
        dish.ifPresent(d -> System.out.println(d.getName()));
    }

    private static boolean isVegetarianFriendMenu() {
        return Dish.menu.stream().allMatch(Dish::getVegetarian);
    }

    private static boolean isHealthyMenu() {
        return Dish.menu.stream().allMatch(d -> d.getCalories() < 1000);
    }

    private static boolean isHealthyMenu2() {
        return Dish.menu.stream().noneMatch(d -> d.getCalories() >= 1000);
    }

    private static Optional<Dish> findVegetarianDish() {
        return Dish.menu.stream().filter(Dish::getVegetarian).findAny();
    }
}
