package com.wbs.java8lambda.chapter3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * TODO
 *
 * @author: wangbingshuai
 * @create: 2019-10-30 15:42
 **/
public class ExecuteAround {
    public static void main(String[] args) throws IOException {
        String result = processFileLimited();
        System.out.println(result);

        System.out.println("---");

        String oneLine = processFile((BufferedReader b) -> b.readLine());
        System.out.println(oneLine);

        System.out.println("---");

        String twoLine = processFile((BufferedReader br) -> br.readLine() + br.readLine());
        System.out.println(twoLine);
    }

    private static String processFileLimited() throws IOException {
        // 这里的相对路径不管用的话，需要改成绝对路径
        try (BufferedReader br = new BufferedReader(new FileReader("lambdasinaction/chap3/data.txt"))) {
            return br.readLine();
        }
    }

    private static String processFile(BufferedReaderProcessor p) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("lambdasinaction/chap3/data.txt"))) {
            return p.process(br);
        }
    }
}
