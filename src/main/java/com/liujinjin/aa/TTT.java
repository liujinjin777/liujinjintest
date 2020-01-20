package com.liujinjin.aa;

import lombok.Getter;

import java.lang.reflect.ParameterizedType;

/**
 * @author liuxin
 * @date 2018/6/14
 */
public class TTT<T> {

    public A a = new A();

    @Getter
    private A a1 = new A();

    public Class<T> get() {

        Class<T> tClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

        return tClass;
    }

    public class A{
        int i = 0;

        public void ss(){
            System.out.println(1111);
        }

        @Override
        public String toString() {
            return "A{" +
                    "i=" + i +
                    '}';
        }
    }

}
