package com.liujinjin.book.head.first.iterator.before;

/**
 * @author liuxin
 * @date 2018/6/27
 */
public class Main {

    public static void main(String[] args) {
        PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
        DinerMenu dinerMenu = new DinerMenu();

        Alice alice = new Alice(pancakeHouseMenu, dinerMenu);
        alice.printAllMenus();
    }
}
