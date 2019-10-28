package com.wbs.java8lambda.chapter2;

import com.wbs.java8lambda.entity.Apple;

/**
 * TODO
 *
 * @author: wangbingshuai
 * @create: 2019-10-28 16:56
 **/
public class AppleWeightPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return apple.getWeight() > 150;
    }
}
