package com.liujinjin.book.pattern.abstractFactory;

/**
 * @author liuxin
 * @date 2018/5/4
 */
public class Creator1 extends AbstractCreator {
    @Override
    public AbstractProductA createProductA() {
        return new ProductA1();
    }

    @Override
    public AbstractProductB createProductB() {
        return new ProductB1();
    }

}
