package com.liujinjin.temp;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

/**
 * Created by liuxin on 2017/8/24.
 */
public class T6 {

    public static void main(String[] args) {
        String s2 = "[\"a\",\"b\",\"c\"]";
        List<String> strings = JSON.parseArray(s2, String.class);
        System.out.println(strings);


        String s = "新天龙八部|九鼎传说|新水浒Q传|鹿鼎记|桃园2.0|斗破苍穹";
        String[] split = s.split("\\|");
        System.out.println(split);

        System.out.println(
                Arrays.asList(split)
        );

        String title = "请输入qq号码";
        System.out.println(getTitle(title));

        String title1 = "输入魔兽账号";
        System.out.println(getTitle(title1));

        System.out.println(
                Arrays.asList(1,2,3,4,5).contains(0)
        );

    }


    private static String getTitle(String gamesDefaultTitle) {
        if(StringUtils.isBlank(gamesDefaultTitle)) return "";

        if(gamesDefaultTitle.contains("请输入")){
            int i = gamesDefaultTitle.indexOf("请输入");
            gamesDefaultTitle = gamesDefaultTitle.substring(i+3);
        } else if (gamesDefaultTitle.contains("输入")){
            int i = gamesDefaultTitle.indexOf("输入");
            gamesDefaultTitle = gamesDefaultTitle.substring(i+2);
        }

        return gamesDefaultTitle;
    }
}
