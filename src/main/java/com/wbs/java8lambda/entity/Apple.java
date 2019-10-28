package com.wbs.java8lambda.entity;

import lombok.*;

/**
 * 苹果实体类
 *
 * @author: wangbingshuai
 * @create: 2019-10-28 15:07
 **/
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Apple {
    /**
     * 重量
     */
    private Integer weight;
    /**
     * 颜色
     */
    private String color;
}
