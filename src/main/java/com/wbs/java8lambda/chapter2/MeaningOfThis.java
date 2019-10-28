package com.wbs.java8lambda.chapter2;

/**
 * TODO
 *
 * @author: wangbingshuai
 * @create: 2019-10-28 17:10
 **/
public class MeaningOfThis {
    public static int value = 4;

    public void doIt() {
        int value = 6;
        Runnable runnable = new Runnable() {
            public final int value = 5;

            @Override
            public void run() {
                int value = 10;
                System.out.println(this.value);
            }
        };
        runnable.run();
    }

    public static void main(String[] args) {
        MeaningOfThis meaningOfThis = new MeaningOfThis();
        meaningOfThis.doIt();
    }

}
