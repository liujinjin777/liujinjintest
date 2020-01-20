package com.liujinjin.book.bingfa.four.case2;

import lombok.Data;

/**
 * @author liuxin
 * @date 2018/9/2
 */
@Data
public class Point {
    public final int x, y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}
