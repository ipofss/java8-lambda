package com.wbs.java8lambda.chapter8;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * TODO
 *
 * @author: wangbingshuai
 * @create: 2019-11-06 20:20
 **/
public class FactoryMain {
    public static void main(String[] args) {
        Product p1 = ProductFactory.createProduct("loan");

        Supplier<Product> loadSupplier = Loan::new;
        Product p2 = loadSupplier.get();

        Product p3 = ProductFactory.createProductLambda("loan");
    }

    private static class ProductFactory {
        public static Product createProduct(String name) {
            switch (name) {
                case "loan":
                    return new Loan();
                case "stock":
                    return new Stock();
                case "bond":
                    return new Bond();
                default:
                    throw new RuntimeException("No such product " + name);
            }
        }

        public static Product createProductLambda(String name) {
            Supplier<Product> productSupplier = map.get(name);
            if (productSupplier != null) {
                return productSupplier.get();
            }
            throw new RuntimeException("No such product " + name);
        }
    }

    interface Product {
    }

    private static class Loan implements Product {
    }

    private static class Stock implements Product {
    }

    private static class Bond implements Product {
    }

    final static private Map<String, Supplier<Product>> map = new HashMap<>();

    static {
        map.put("loan", Loan::new);
        map.put("stock", Stock::new);
        map.put("bond", Bond::new);
    }
}
