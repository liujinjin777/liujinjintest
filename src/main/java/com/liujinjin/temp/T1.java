package com.liujinjin.temp;

import com.alibaba.fastjson.JSON;
import com.liujinjin.java8.methodReference.People;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by liuxin on 2017/4/25.
 */
public class T1 {

    public static void main(String[] args) {

        Date date = new Date();
        System.out.println(JSON.toJSONString(date));

    }

    public void test2() throws ParseException {
        String StrD ="2015-04-20 11:22:45";
        SimpleDateFormat sdfd =new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
        Date dat =sdfd.parse(StrD);


    }

    public void test(){
        System.out.println(Site.XIECHENG);
        Map<Site, Integer> map = new HashMap<>();
        map.put(Site.XIECHENG, 1);

        System.out.println(map.get(Site.XIECHENG));

        List<People> peoples = new ArrayList<>();
        People people = new People();
        people.setName("1");
        People people2 = new People();
        people2.setName("1");
        people2.setFlag(false);

        peoples.add(people);
        peoples.add(people2);

        System.out.println(
                JSON.toJSONString(
                        peoples.stream().filter(People::getFlag).collect(Collectors.toList())
                )
        );
    }


}
