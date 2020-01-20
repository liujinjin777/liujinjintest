package com.liujinjin.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuxin
 * @date 2018/10/30
 */
public class GenericityTest<T> {

    @Test
    public void test1() throws ClassNotFoundException {
        List<String> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        System.out.println(list.getClass() == list2.getClass());

        // List<String>[] listArray = new List<String>[]{};
        // String[] ad = new String[]{};

        if (list instanceof List){

        }

        try {
            Class<?> aClass = Class.forName("");
        } catch (ClassNotFoundException e) {


        }


    }


    class Base {
        public Number doStuff() {
            return 0;
        }
    }


    class Sub extends Base {
        @Override
        public Integer doStuff() {
            return 0;
        }
    }

}
