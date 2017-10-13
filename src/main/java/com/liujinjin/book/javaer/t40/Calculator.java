package com.liujinjin.book.javaer.t40;

/**
 * Created by liuxin on 2017/8/21.
 */
public class Calculator {
    private int i, j, result;

    public Calculator(){}

    public Calculator(int i, int j){
        this.i = i;
        this.j = j;
    }

    protected void setOperator(int operator){
        result = operator == 1 ? i+j : i-j;
    }

    public int getResult(){
        return result;
    }
}
