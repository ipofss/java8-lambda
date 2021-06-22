package com.wbs.java8lambda.chapter11;

/**
 * TODO
 *
 * @author: wangbingshuai
 * @create: 2019-11-11 20:25
 **/
public class Discount {
    public enum Code {
        NONE(0), SILVER(5), GOLD(10), PLATINUM(25), DIAMOND(20);
        private final int percentage;

        Code(int percentage) {
            this.percentage = percentage;
        }
    }

    private static double apply(double price, Code code) {
        Util.delay();
        return Util.format(price * (100 - code.percentage) / 100);
    }

    public static String applyDiscount(Quote quote) {
        return quote.getShopName() + " price is " + Discount.apply(quote.getPrice(), quote.getDiscountCode());
    }
}
