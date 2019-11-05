package com.wbs.java8lambda.chapter6;

import com.wbs.java8lambda.entity.Dish;
import com.wbs.java8lambda.entity.Type;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * TODO
 *
 * @author: wangbingshuai
 * @create: 2019-11-05 14:48
 **/
public class Partitioning {
    public static void main(String[] args) {
        System.out.println("Dishes partitioned by vegetarian: " + partitionByVegetarian());
        System.out.println("Vegetarian Dishes by type: " + vegetarianDishesByType());
        System.out.println("Most caloric dishes by vegetarian: " + mostCaloricPartitionedByVegetarian());
    }

    private static Map<Boolean, List<Dish>> partitionByVegetarian() {
        return Dish.menu.stream().collect(Collectors.partitioningBy(Dish::getVegetarian));
    }

    private static Map<Boolean, Map<Type, List<Dish>>> vegetarianDishesByType() {
        return Dish.menu.stream().collect(Collectors.partitioningBy(Dish::getVegetarian, Collectors.groupingBy(Dish::getType)));
    }

    private static Object mostCaloricPartitionedByVegetarian() {
        return Dish.menu.stream()
                .collect(Collectors.partitioningBy(Dish::getVegetarian,
                        Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingInt(Dish::getCalories)), Optional::get)));
    }
}
