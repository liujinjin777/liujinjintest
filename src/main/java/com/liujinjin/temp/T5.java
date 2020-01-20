package com.liujinjin.temp;

import java.math.BigDecimal;

/**
 * Created by liuxin on 2017/8/14.
 */
public class T5 {

    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal(12);

        BigDecimal multiply = bigDecimal.multiply(BigDecimal.valueOf(9.995345340));
        System.out.println(multiply);
    }
}
