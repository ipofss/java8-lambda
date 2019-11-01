package com.wbs.java8lambda.chapter5;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * TODO
 *
 * @author: wangbingshuai
 * @create: 2019-10-31 19:30
 **/
@Getter
@AllArgsConstructor
public class Transaction {
    private Trader trader;
    private Integer year;
    private Integer value;

    @Override
    public String toString() {
        return "{" + this.trader + ", year:" + this.year + ", value:" + this.value;
    }
}
