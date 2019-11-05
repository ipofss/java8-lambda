package com.wbs.java8lambda.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Arrays;
import java.util.List;

/**
 * TODO
 *
 * @author: wangbingshuai
 * @create: 2019-10-30 19:15
 **/
@Getter
@AllArgsConstructor
@ToString
public class Dish {
    private final String name;
    private final Boolean vegetarian;
    private final Integer calories;
    private final Type type;

    public static final List<Dish> menu =
            Arrays.asList(new Dish("pork", false, 800, Type.MEAT),
                    new Dish("beef", false, 700, Type.MEAT),
                    new Dish("chicken", false, 400, Type.MEAT),
                    new Dish("french fries", true, 530, Type.OTHER),
                    new Dish("rice", true, 350, Type.OTHER),
                    new Dish("season fruit", true, 120, Type.OTHER),
                    new Dish("pizza", true, 550, Type.OTHER),
                    new Dish("prawns", false, 400, Type.FISH),
                    new Dish("salmon", false, 450, Type.FISH));
}
