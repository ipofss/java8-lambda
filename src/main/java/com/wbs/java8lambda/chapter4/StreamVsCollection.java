package com.wbs.java8lambda.chapter4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * TODO
 *
 * @author: wangbingshuai
 * @create: 2019-10-30 19:38
 **/
public class StreamVsCollection {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Java8", "Lambdas", "In", "Action");
        Stream<String> stream = names.stream();
        stream.forEach(System.out::println);
//        stream.forEach(System.out::println);
    }
}
