package com.liujinjin.suanfa.common;

import java.util.Arrays;

/**
 * 自定义栈-数组
 *
 * Created by liuxin on 17/2/14.
 */
public class MyArrayStack<T> {

    private Object[] array;
    private int size = 0;

    public MyArrayStack(){
        this(10);
    }

    public MyArrayStack(int length){
        array = new Object[length];
    }

    /**
     * 入栈
     *
     * @param data
     */
    public void push(T data){
        size++;

        // 扩容
        if(size > array.length-1){
            int length = array.length * 3/2;
            Object[] newArray = new Object[length];
            for(int i = 0; i < array.length; i++){
                newArray[i] = array[i];
            }
            array = newArray;
        }

        array[size] = data;

    }

    /**
     * 出栈
     */
    public T pop(){
        if(size == 0) return null;

        T data = (T)array[size];
        size--;

        return data;
    }

    /**
     * 是否为空
     */
    public boolean isEmpty(){
        return size == 0 ? true : false;
    }

    public boolean isNotEmpty(){
        return !isEmpty();
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}
