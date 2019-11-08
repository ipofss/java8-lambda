package com.wbs.java8lambda.chapter9;

import java.util.function.Function;

/**
 * TODO
 *
 * @author: wangbingshuai
 * @create: 2019-11-07 20:26
 **/
public class Letter {
    public static void main(String[] args) {
        Function<String, String> addHeader = Letter::addHeader;
        Function<String, String> transformationPipeline = addHeader.andThen(Letter::checkSpelling).andThen(Letter::addFooter);
        System.out.println(transformationPipeline.apply("C++ stay away from me!"));
    }

    private static String addHeader(String text) {
        return "From Raoul, Mario and Alan:" + text;
    }

    private static String addFooter(String text) {
        return text + "Kind regards";
    }

    private static String checkSpelling(String text) {
        return text.replaceAll("C\\+\\+", "**Censored**");
    }
}
