package com.liujinjin.ql;

import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;
import org.junit.Test;

/**
 * @author liuxin23
 * @date 2020/01/17
 */
public class Test20200119 {
    /**
     //支持 +,-,*,/,<,>,<=,>=,==,!=,<>【等同于!=】,%,mod【取模等同于%】,++,--,
     //in【类似sql】,like【sql语法】,&&,||,!,等操作符
     //支持for，break、continue、if then else 等标准的程序控制逻辑
            n=10;
     */
    @Test
    public void test1() throws Exception {
        ExpressRunner runner = new ExpressRunner();
        DefaultContext<String, Object> context = new DefaultContext<String, Object>();
        context.put("a",1);
        context.put("b",2);
        context.put("c",3);
        String express = "(a+b) == c";
        Object r = runner.execute(express, context, null, true, false);
        System.out.println(r);
    }



}
