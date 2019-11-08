package com.wbs.java8lambda.chapter9;

/**
 * TODO
 *
 * @author: wangbingshuai
 * @create: 2019-11-07 20:19
 **/
public class Diamond {
    public static void main(String[] args) {
        new D().hello();
    }

    private interface A {
        default void hello() {
            System.out.println("Hello from A");
        }
    }

    private interface B extends A {
    }

    private interface C extends A {
    }

    static class D implements B, C {

    }
}
