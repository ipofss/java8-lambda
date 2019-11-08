package com.wbs.java8lambda.chapter9;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * TODO
 *
 * @author: wangbingshuai
 * @create: 2019-11-08 14:49
 **/
public class Intro {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 5, 1, 2, 6);
        numbers.sort(Comparator.naturalOrder());
        System.out.println(numbers);
    }
}
