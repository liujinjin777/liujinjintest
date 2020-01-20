package com.liujinjin.book.head.first.iterator.after.iter;

import com.liujinjin.book.head.first.iterator.after.MenuUnit;

import java.util.List;

/**
 * @author liuxin
 * @date 2018/6/27
 */
public class PancakeHouseIterator implements MyIterator {

    private List<MenuUnit> menuUnitList;
    private int i = 0;

    public PancakeHouseIterator(List<MenuUnit> menuUnitList){
        this.menuUnitList = menuUnitList;
    }

    @Override
    public boolean hasNext() {
        return menuUnitList.size() > i && menuUnitList.get(i) != null;
    }

    @Override
    public Object next() {
        MenuUnit menuUnit = menuUnitList.get(i);
        i++;
        return menuUnit;
    }
}
