package com.wbs.java8lambda.chapter3;

import com.wbs.java8lambda.entity.Apple;

import java.util.Comparator;

/**
 * TODO
 *
 * @author: wangbingshuai
 * @create: 2019-10-30 15:17
 **/
public class AppleComparator implements Comparator<Apple> {

    @Override
    public int compare(Apple o1, Apple o2) {
        return o1.getWeight().compareTo(o2.getWeight());
    }
}
