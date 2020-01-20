package com.liujinjin.book.head.first.iterator.after.iter;

import com.liujinjin.book.head.first.iterator.after.MenuUnit;

/**
 * @author liuxin
 * @date 2018/6/27
 */
public class DinerIterator implements MyIterator {
    private MenuUnit[] array;
    private int position = 0;

    public DinerIterator(MenuUnit[] array){
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        return !(position >= array.length || array[position] == null);
    }

    @Override
    public Object next() {
        MenuUnit menuUnit = array[position];
        position++;
        return menuUnit;
    }
}
