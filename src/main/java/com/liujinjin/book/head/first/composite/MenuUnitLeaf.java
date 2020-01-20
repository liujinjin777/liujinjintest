package com.liujinjin.book.head.first.composite;

import lombok.Data;

/**
 * 菜单项
 *
 * @author liuxin
 * @date 2018/6/27
 */
@Data
public class MenuUnitLeaf implements MenuComponent {
    private String name;
    private String description;
    private boolean vegetarian; // 是否为素食
    private double price;

    @Override
    public void print() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "MenuUnitLeaf{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", vegetarian=" + vegetarian +
                ", price=" + price +
                '}';
    }
}
