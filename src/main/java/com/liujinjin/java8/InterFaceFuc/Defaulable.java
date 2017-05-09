package com.liujinjin.java8.InterFaceFuc;

/**
 * Created by liuxin on 2017/4/24.
 */
public interface Defaulable {
    // Interfaces now allow default methods, the implementer may or
    // may not implement (override) them.
    default String notRequired() {
        return "Default implementation";
    }
}
