package com.wbs.java8lambda.chapter11;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/**
 * TODO
 *
 * @author: wangbingshuai
 * @create: 2019-11-11 20:04
 **/
public class Util {

    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.##", new DecimalFormatSymbols(Locale.US));

    public static void delay() {
        int delay = 1000;
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static double format(double number) {
        synchronized (DECIMAL_FORMAT) {
            return new Double(DECIMAL_FORMAT.format(number));
        }
    }

}
