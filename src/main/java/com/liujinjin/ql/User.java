package com.liujinjin.ql;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

/**
 * @author liuxin
 * @date 2019/3/19
 */
@Data
public class User {

    /**
     * 标识
     */
    private long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 年龄
     */
    private int age;

    public static String firstToUpper(String value) {
        if (StringUtils.isBlank(value)) {
            return "";
        }
        value = StringUtils.trim(value);
        String f = StringUtils.substring(value, 0, 1);
        String s = "";
        if (value.length() > 1) {
            s = StringUtils.substring(value, 1);
        }
        return f.toUpperCase() + s;
    }
}
