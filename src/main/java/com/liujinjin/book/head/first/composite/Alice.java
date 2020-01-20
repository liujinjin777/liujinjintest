package com.liujinjin.book.head.first.composite;

/**
 * @author liuxin
 * @date 2018/6/27
 */
public class Alice {

    private MenuComponent menuComponent;

    public Alice(MenuComponent allMenus){
        this.menuComponent = allMenus;
    }

    public void print(){
        menuComponent.print();
    }

}
