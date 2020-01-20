package com.liujinjin.book.bingfa.four.case1;

/**
 * @author liuxin
 * @date 2018/9/2
 */
public class MutablePoint {
    public int x,y;

    public MutablePoint(){
        x = 0;
        y = 0;
    }

    public MutablePoint(MutablePoint mutablePoint){
        x = mutablePoint.x;
        y = mutablePoint.y;
    }


}