package com.liujinjin.book.bingfa.four.case2;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * case2 委托（安全层下沉）
 * 使用ConcurrentHashMap+不可变类来实现线程安全
 *
 * @author liuxin
 * @date 2018/9/2
 */
public class DelegatingVehicleTracker {

    private final ConcurrentHashMap<String, Point> locations;
    private final Map<String, Point> unmodifiableMap;

    public DelegatingVehicleTracker (Map<String, Point> pointMap){
        locations = new ConcurrentHashMap<>(pointMap);
        unmodifiableMap = Collections.unmodifiableMap(locations);
    }

    public Map<String, Point> getLocations(){
        return unmodifiableMap;
    }

    public Point getLocation(String id){
        return locations.get(id);
    }

    public void setLocation(String id, int x, int y){
        locations.replace(id, new Point(x, y));
    }

}
