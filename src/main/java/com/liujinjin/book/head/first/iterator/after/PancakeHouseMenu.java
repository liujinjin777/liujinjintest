package com.liujinjin.book.head.first.iterator.after;

import com.google.common.collect.Lists;
import com.liujinjin.book.head.first.iterator.after.iter.MyIterator;
import com.liujinjin.book.head.first.iterator.after.iter.PancakeHouseIterator;

import java.util.List;

/**
 * 煎饼屋菜单
 *
 * @author liuxin
 * @date 2018/6/27
 */
public class PancakeHouseMenu {

    private List<MenuUnit> menuUnitList;

    public PancakeHouseMenu(){
        menuUnitList = Lists.newArrayList();

        MenuUnit menuUnit = new MenuUnit();
        menuUnit.setName("kb pancake breakfast");
        menuUnit.setDescription("pancakes with fried eggs, and toast");
        menuUnit.setVegetarian(true);
        menuUnit.setPrice(2.99);

        // ...
        menuUnitList.add(menuUnit);
    }

    public List<MenuUnit> getMenuUnitList(){
        return menuUnitList;
    }

    public MyIterator createIterator(){
        return new PancakeHouseIterator(this.menuUnitList);
    }

}
