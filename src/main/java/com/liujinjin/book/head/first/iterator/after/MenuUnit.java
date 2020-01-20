package com.liujinjin.book.head.first.iterator.after;

import lombok.Data;

/**
 * 菜单上一道菜（菜单单元）
 * 菜单项
 *
 * @author liuxin
 * @date 2018/6/27
 */
@Data
public class MenuUnit {
    private String name;
    private String description;
    private boolean vegetarian; // 是否为素食
    double price;
}
