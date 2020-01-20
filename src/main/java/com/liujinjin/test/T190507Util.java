package com.liujinjin.test;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author liuxin
 * @date 2019/5/7
 */
public class T190507Util {

    @Test
    public void test() {
        ArrayList<String> strings = Lists.newArrayList("1", "3", "4", "2", "5", "7", "1000", "6");
        List<String> sortedUploadKafkaS = strings.stream()
                .sorted(Comparator.comparing(a -> Integer.valueOf(a)))
                .collect(Collectors.toList());

        System.out.println(JSON.toJSONString(sortedUploadKafkaS));

        String format = String.format("shishishi %s%% %s%%", String.valueOf(1D), String.valueOf(2D));
        System.out.println(format);

        System.out.println("shishishi" + 1D + 1D);
    }



}
