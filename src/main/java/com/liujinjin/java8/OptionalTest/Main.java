package com.liujinjin.java8.OptionalTest;

import com.liujinjin.java8.methodReference.People;

import java.util.Optional;

/**
 * Created by liuxin on 2017/4/24.
 */
public class Main {

    public static void main(String[] args) {
        Optional< String > fullName = Optional.ofNullable( null );
        // 是否为null
        System.out.println( "Full Name is set? " + fullName.isPresent() );
        System.out.println( "Full Name: " + fullName.orElseGet( () -> "[none]" ) );
        System.out.println( fullName.map( s -> "Hey " + s + "!" ).orElse( "Hey Stranger!" ) );

        People p = new People();
        
    }
}
