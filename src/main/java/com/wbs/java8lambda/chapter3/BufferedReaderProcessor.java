package com.wbs.java8lambda.chapter3;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * TODO
 *
 * @author: wangbingshuai
 * @create: 2019-10-30 15:52
 **/
@FunctionalInterface
public interface BufferedReaderProcessor {
    String process(BufferedReader br) throws IOException;
}
