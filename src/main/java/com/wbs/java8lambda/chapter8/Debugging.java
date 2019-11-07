package com.wbs.java8lambda.chapter8;

import java.util.Arrays;
import java.util.List;

/**
 * TODO
 *
 * @author: wangbingshuai
 * @create: 2019-11-07 11:58
 **/
public class Debugging {
    public static void main(String[] args) {
        List<Point> points = Arrays.asList(new Point(12, 2), null);
        points.stream().map(Point::getX).forEach(System.out::println);
    }

    private static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }
    }
}
