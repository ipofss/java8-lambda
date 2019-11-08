package com.wbs.java8lambda.chapter9;

/**
 * TODO
 *
 * @author: wangbingshuai
 * @create: 2019-11-07 20:14
 **/
public class Ambiguous {
    public static void main(String[] args) {
        new C().hello();
    }

    private interface A {
        default void hello() {
            System.out.println("Hello from A");
        }
    }

    private interface B {
        default void hello() {
            System.out.println("Hello from B");
        }
    }

    private static class C implements B, A {
        @Override
        public void hello() {
            A.super.hello();
        }
    }
}
