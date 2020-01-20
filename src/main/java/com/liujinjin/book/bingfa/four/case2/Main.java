package com.liujinjin.book.bingfa.four.case2;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @author liuxin
 * @date 2018/9/2
 */
public class Main {


    public static void main(String[] args) {

        Map<String, Point> pointMap = Maps.newHashMap();
        pointMap.put("1", new Point(1, 2));
        pointMap.put("2", new Point(1, 2));
        DelegatingVehicleTracker tracker = new DelegatingVehicleTracker(pointMap);
        Map<String, Point> locations1 = tracker.getLocations();
        System.out.println(JSON.toJSONString(locations1));

        System.out.println("-----------");
        tracker.setLocation("2", 3, 4);
        Map<String, Point> locations2 = tracker.getLocations();
        System.out.println(JSON.toJSONString(locations1));
        System.out.println(JSON.toJSONString(locations2));


    }



    public static void pri(Map<String, Point> map){
        for(String id : map.keySet()){
            System.out.println(id + "   " + map.get(id));
        }
    }
}
