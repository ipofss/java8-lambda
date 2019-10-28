package com.wbs.java8lambda.chapter2;

import com.wbs.java8lambda.entity.Apple;

/**
 * TODO
 *
 * @author: wangbingshuai
 * @create: 2019-10-28 16:57
 **/
public class AppleColorPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return "green".equals(apple.getColor());
    }
}
