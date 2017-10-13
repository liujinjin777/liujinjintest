package com.liujinjin.temp;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by liuxin on 2017/9/21.
 */
public class T11 {

    public static void main(String[] args) {
        Integer i = null;
        String str = "1";

        assert i != null && StringUtils.isNotBlank(str);

        System.out.println(1);
    }
}
