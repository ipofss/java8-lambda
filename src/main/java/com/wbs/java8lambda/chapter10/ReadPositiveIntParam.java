package com.wbs.java8lambda.chapter10;

import java.util.Optional;
import java.util.Properties;

/**
 * TODO
 *
 * @author: wangbingshuai
 * @create: 2019-11-09 14:55
 **/
public class ReadPositiveIntParam {

    public static void main(String[] args) {
        Properties props = new Properties();
        props.setProperty("a", "5");
        props.setProperty("b", "true");
        props.setProperty("c", "-3");

        System.out.println(readDurationImperative(props, "a"));
        System.out.println(readDurationImperative(props, "b"));
        System.out.println(readDurationImperative(props, "c"));
        System.out.println(readDurationImperative(props, "d"));

        System.out.println(readDurationWithOptional(props, "a"));
        System.out.println(readDurationWithOptional(props, "b"));
        System.out.println(readDurationWithOptional(props, "c"));
        System.out.println(readDurationWithOptional(props, "d"));
    }

    private static int readDurationImperative(Properties props, String name) {
        String value = props.getProperty(name);
        if (value != null) {
            try {
                int i = Integer.parseInt(value);
                if (i > 0) {
                    return i;
                }
            } catch (NumberFormatException nfe) {

            }
        }
        return 0;
    }

    private static int readDurationWithOptional(Properties props, String name) {
        return Optional.ofNullable(props.getProperty(name))
                .flatMap(ReadPositiveIntParam::s2i)
                .filter(i -> i > 0).orElse(0);
    }

    private static Optional<Integer> s2i(String s) {
        try {
            return Optional.of(Integer.parseInt(s));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }
}
