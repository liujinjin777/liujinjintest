package com.liujinjin.book.pattern.abstractFactory;

/**
 * @author liuxin
 * @date 2018/5/4
 */
public class Creator2 extends AbstractCreator {
    //        2 A
    @Override
    public AbstractProductA createProductA() {
        return new ProductA2();
    }

    //        2 B
    @Override
    public AbstractProductB createProductB() {
        return new ProductB2();
    }

}
