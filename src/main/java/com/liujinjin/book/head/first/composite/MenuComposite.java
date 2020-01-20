package com.liujinjin.book.head.first.composite;

import lombok.Data;
import org.apache.commons.collections.CollectionUtils;

import java.util.List;

/**
 * 菜单
 *
 * @author liuxin
 * @date 2018/6/27
 */
@Data
public class MenuComposite implements MenuComponent {

    private String menuCompositeName;

    private List<MenuComponent> menuComponents;

    @Override
    public void print() {
        System.out.println("菜单名：" + menuCompositeName);
        if(CollectionUtils.isEmpty(menuComponents)){
            return;
        }
        for(MenuComponent menuComponent : menuComponents){
            menuComponent.print();
        }
    }
}
