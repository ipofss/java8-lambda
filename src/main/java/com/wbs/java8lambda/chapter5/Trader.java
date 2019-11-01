package com.wbs.java8lambda.chapter5;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * TODO
 *
 * @author: wangbingshuai
 * @create: 2019-10-31 19:27
 **/
@Setter
@Getter
@AllArgsConstructor
public class Trader {
    private String name;
    private String city;

    @Override
    public String toString() {
        return "Trader:" + this.name + " in " + this.city;
    }
}
