package com.liujinjin.temp;

import java.math.BigDecimal;
import java.text.Collator;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuxin on 2017/8/24.
 */
public class T7 {

    public static void main(String[] args) {
        String a = "啊";
        String b = "吧";
        String c = "吃";
        String d = "的";

        List<String> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);

        list.sort(Collator.getInstance(java.util.Locale.CHINA));

        System.out.println(list);

        System.out.println(
                BigDecimal.ZERO.compareTo(BigDecimal.valueOf(0.000))
        );

    }
}
