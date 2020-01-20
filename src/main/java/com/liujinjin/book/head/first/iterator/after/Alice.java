package com.liujinjin.book.head.first.iterator.after;

import com.liujinjin.book.head.first.iterator.after.iter.MyIterator;

/**
 * 女招待 alice
 *
 * @author liuxin
 * @date 2018/6/27
 */
public class Alice {

    private PancakeHouseMenu pancakeHouseMenu;  // 煎饼屋菜单
    private DinerMenu dinerMenu;  // 餐厅菜单

    public Alice (PancakeHouseMenu pancakeHouseMenu, DinerMenu dinerMenu){
        this.pancakeHouseMenu = pancakeHouseMenu;
        this.dinerMenu = dinerMenu;
    }

    /**
     *  打印所有菜单
     */
    public void printAllMenus(){
        MyIterator iterator = pancakeHouseMenu.createIterator();
        this.print(iterator);

        MyIterator iterator1 = dinerMenu.createIterator();
        this.print(iterator1);

    }

    private void print(MyIterator iterator){
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

}
