package com.wbs.java8lambda.chapter3;

import com.wbs.java8lambda.entity.Apple;

/**
 * TODO
 *
 * @author: wangbingshuai
 * @create: 2019-10-30 15:31
 **/
@FunctionalInterface
public interface ApplePredicate {
    boolean test(Apple a);
}
