package com.liujinjin.book.head.first.composite;

import com.google.common.collect.Lists;

/**
 * @author liuxin
 * @date 2018/6/27
 */
public class Main {

    public static void main(String[] args) {
        MenuComposite allMenus = new MenuComposite();
        allMenus.setMenuCompositeName("总菜单");

        MenuComposite pancakeHouseMenu = new MenuComposite();
        pancakeHouseMenu.setMenuCompositeName("煎饼屋菜单");
        MenuComposite dinerMenu = new MenuComposite();
        dinerMenu.setMenuCompositeName("餐厅菜单");
        allMenus.setMenuComponents(Lists.newArrayList(pancakeHouseMenu, dinerMenu));

        MenuComposite dessertMenu = new MenuComposite();
        dessertMenu.setMenuCompositeName("甜点菜单");
        dinerMenu.setMenuComponents(Lists.newArrayList(dessertMenu));

        MenuUnitLeaf menuUnitLeaf = new MenuUnitLeaf();
        menuUnitLeaf.setName("粥");
        menuUnitLeaf.setDescription("皮蛋瘦肉粥");
        menuUnitLeaf.setPrice(6);
        menuUnitLeaf.setVegetarian(false);
        pancakeHouseMenu.setMenuComponents(Lists.newArrayList(menuUnitLeaf));


        // 获取所有菜单
        Alice alice = new Alice(allMenus);
        alice.print();



    }


}
