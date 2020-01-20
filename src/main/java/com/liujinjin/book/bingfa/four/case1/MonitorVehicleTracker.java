package com.liujinjin.book.bingfa.four.case1;

import com.google.common.collect.Maps;

import java.util.Collections;
import java.util.Map;

/**
 * 例子：监控车最新位置记录，车位置用x，y坐标表示
 * case1
 * MutablePoint和map都为非并发安全类
 * 使用复制+synchronized实现并发安全
 * 复制：防止引用泄漏
 * synchronized：防止并发
 *
 * 缺点：随着车越来越多，复制的时间越来越长
 *      如果需要每辆车的位置，会频繁复制
 *      如果车的位置发生变化，由于是复制方式，client方不会变为最新位置（视需求而定）
 *
 * @author liuxin
 * @date 2018/9/2
 */
public class MonitorVehicleTracker {

    private final Map<String, MutablePoint> locations;

    public MonitorVehicleTracker(Map<String, MutablePoint> locations){
        this.locations = deepCopy(locations);
    }

    public synchronized Map<String, MutablePoint> getLocations(){
        return deepCopy(locations);
    }

    public synchronized MutablePoint getLocation(String id){
        MutablePoint mutablePoint = locations.get(id);
        return mutablePoint == null ? null : new MutablePoint(mutablePoint);
    }

    public synchronized void setLocations(String id, int x, int y){
        MutablePoint loc = locations.get(id);
        if (loc == null){
            throw new RuntimeException("no such");
        }

        loc.x = x;
        loc.y = y;
    }


    private static Map<String, MutablePoint> deepCopy(Map<String, MutablePoint> m){
        Map<String, MutablePoint> resp = Maps.newHashMap();
        for (String id : m.keySet()){
            resp.put(id, m.get(id));
        }
        return Collections.unmodifiableMap(resp);
    }
}