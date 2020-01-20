package com.liujinjin.book.pattern.simpleFactory;

/**
 * @author liuxin
 * @date 2018/5/4
 */
public class Factory {

    @SuppressWarnings("unchecked")
    public static <T extends Father>T create(Class<T> c){
        Father father = null;
        try {
            father = (T)Class.forName(c.getName()).newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            System.out.println(e);
        }

        return (T)father;
    }
}
