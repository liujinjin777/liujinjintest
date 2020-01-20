package com.liujinjin.book.head.first.iterator.before;

import java.util.List;

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
        List<MenuUnit> menuUnitList = pancakeHouseMenu.getMenuUnitList();
        for (int i = 0; i < menuUnitList.size(); i++) {
            System.out.println(menuUnitList.get(i));
        }

        MenuUnit[] menuUnitArray = dinerMenu.getMenuUnitArray();
        for (int i = 0; i < menuUnitArray.length; i++) {
            System.out.println(menuUnitArray[i]);
        }
    }

}
