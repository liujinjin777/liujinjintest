package com.liujinjin.temp;

import com.alibaba.fastjson.JSON;
import com.liujinjin.temp.obj.Father;
import com.liujinjin.temp.obj.Son;
import org.junit.Test;

/**
 * @author liuxin
 * @date 2018/3/20
 */
public class TestTrans {

    @Test
    public void test1(){
        Son son = new Son();
        son.setA(1);
        son.setB(2);
        son.setC(3);
        test2(son);
    }

    public void test2(Father father){
        System.out.println(father.getA());
        System.out.println(JSON.toJSONString(father));
        if(father instanceof Son){
            Son son = (Son)father;
            System.out.println(JSON.toJSONString(son));
        }
    }
}
