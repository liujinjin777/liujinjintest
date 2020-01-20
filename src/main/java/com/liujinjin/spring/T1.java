package com.liujinjin.spring;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * @author liuxin
 * @date 2018/6/30
 */
@Service
@Lazy(false)
public class T1 {

    public void te(){
        System.out.println(111111);
    }
}
