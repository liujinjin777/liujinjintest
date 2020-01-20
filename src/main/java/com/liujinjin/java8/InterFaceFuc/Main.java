package com.liujinjin.java8.InterFaceFuc;

/**
 * Created by liuxin on 2017/4/24.
 */
public class Main {

    public static void main(String[] args) {
        Defaulable defaulable = DefaulableFactory.create(DefaultableImpl::new);
        System.out.println(defaulable.notRequired());

        Defaulable ovdefaulable = DefaulableFactory.create(OverridableImpl::new);
        System.out.println(ovdefaulable.notRequired());
    }
}
