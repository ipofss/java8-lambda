package com.wbs.java8lambda.chapter2;

import com.wbs.java8lambda.entity.Apple;

/**
 * TODO
 *
 * @author: wangbingshuai
 * @create: 2019-10-28 16:58
 **/
public class AppleRedAndHeavyPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return "red".equals(apple.getColor()) && apple.getWeight() > 150;
    }
}
