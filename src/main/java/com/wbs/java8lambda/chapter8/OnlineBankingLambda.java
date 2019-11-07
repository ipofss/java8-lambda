package com.wbs.java8lambda.chapter8;

import java.util.function.Consumer;

/**
 * TODO
 *
 * @author: wangbingshuai
 * @create: 2019-11-07 11:53
 **/
public class OnlineBankingLambda {
    public static void main(String[] args) {
        new OnlineBankingLambda().processCustomer(1337, (Customer c) -> System.out.println("Hello!"));
    }

    void processCustomer(int id, Consumer<Customer> makeCustomerHappy) {
        Customer customer = Database.getCustomerWithId(id);
        makeCustomerHappy.accept(customer);
    }

    private static class Customer {
    }

    private static class Database {
        static Customer getCustomerWithId(int id) {
            return new Customer();
        }
    }
}
