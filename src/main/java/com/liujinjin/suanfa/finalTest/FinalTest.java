package com.liujinjin.suanfa.finalTest;

/**
 * Created by liuxin on 17/2/17.
 */
public class FinalTest{
    final int i;
    static FinalTest obj;

    public FinalTest(){
        i  =1;
        /**
         *这里会使正在被构造的对象逸出，如果和上一句做了重排序，那么其他线程就可以通过obj访问到还为被初始化的final域。
         **/
        obj = this;
    }

}
