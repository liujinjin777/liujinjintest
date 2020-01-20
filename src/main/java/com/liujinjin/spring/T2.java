package com.liujinjin.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * @author liuxin
 * @date 2018/7/7
 */
@Service
@Lazy(false)
public class T2 {

    @Autowired
    private T1 t;

    @Autowired
    private T3 t3;

    public void t2(){
        System.out.println(t.hashCode());
    }

    public void t22(){
        System.out.println(t.hashCode());
    }


}
