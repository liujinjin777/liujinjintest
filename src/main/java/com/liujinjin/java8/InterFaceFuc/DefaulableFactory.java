package com.liujinjin.java8.InterFaceFuc;

import java.util.function.Supplier;

/**
 * Created by liuxin on 2017/4/24.
 */
public interface DefaulableFactory {

    // Interfaces now allow static methods
    static Defaulable create( Supplier< Defaulable > supplier ) {
        return supplier.get();
    }

}
