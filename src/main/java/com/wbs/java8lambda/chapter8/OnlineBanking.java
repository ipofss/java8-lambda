package com.wbs.java8lambda.chapter8;

/**
 * TODO
 *
 * @author: wangbingshuai
 * @create: 2019-11-07 11:49
 **/
abstract class OnlineBanking {
    public void processCustomer(int id) {
        Customer customer = Database.getCustomerWithId(id);
        makeCustomerHappy(customer);
    }

    abstract void makeCustomerHappy(Customer customer);

    private static class Customer {
    }

    private static class Database {
        static Customer getCustomerWithId(int id) {
            return new Customer();
        }
    }
}
