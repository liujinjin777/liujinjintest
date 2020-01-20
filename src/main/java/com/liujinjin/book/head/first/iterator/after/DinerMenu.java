package com.liujinjin.book.head.first.iterator.after;

import com.liujinjin.book.head.first.iterator.after.iter.DinerIterator;
import com.liujinjin.book.head.first.iterator.after.iter.MyIterator;

/**
 * 餐厅菜单
 *
 * @author liuxin
 * @date 2018/6/27
 */
public class DinerMenu {

    private MenuUnit[] menuUnitArray;
    private static final int MAX_SIZE = 6;
    private int numberOfItems = 0;

    public DinerMenu(){
        menuUnitArray = new MenuUnit[MAX_SIZE];

        MenuUnit menuUnit = new MenuUnit();
        menuUnit.setName("vegetarian BLT");
        menuUnit.setDescription("   ");
        menuUnit.setVegetarian(true);
        menuUnit.setPrice(2.99);

        // ...
        menuUnitArray[numberOfItems] = menuUnit;
        numberOfItems++;
    }

    public MenuUnit[] getMenuUnitArray(){
        return menuUnitArray;
    }

    public MyIterator createIterator(){
        return new DinerIterator(this.menuUnitArray);
    }
}
