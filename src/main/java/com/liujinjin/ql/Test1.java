package com.liujinjin.ql;

import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;
import com.ql.util.express.IExpressContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.BasicConfigurator;
import org.junit.Before;
import org.junit.Test;

/**
 * @author liuxin
 * @date 2019/3/19
 */
@Slf4j
public class Test1 {

    @Before
    public void before(){
        BasicConfigurator.configure();
    }

    @Test
    public void helloTest() throws Exception {

        ExpressRunner runner = new ExpressRunner();
        DefaultContext<String, Object> context = new DefaultContext<>();
        context.put("a", 1);
        context.put("b", 2);
        String express = "a-b";
        Object r = runner.execute(express, context, null, true, true);
        log.info("{}", r);

    }

    @Test
    public void operateLoopTest() throws Exception {
        final String express = "int n=10;" +
                "int sum=0;int i = 0;" +
                "for(i=0;i<n;i++){" +
                "sum=sum+i;" +
                "}" +
                "return sum;";
        ExpressRunner runner = new ExpressRunner();
        DefaultContext<String, Object> context = new DefaultContext<>();
        Object r = runner.execute(express, context, null, true, true);
        System.out.println(r);
    }

    @Test
    public void test3() throws Exception {
        String exp = "首字母大写(\"abcd\")";
        ExpressRunner runner = new ExpressRunner();
        runner.addFunctionOfClassMethod("首字母大写", User.class.getName(), "firstToUpper", new String[]{"String"}, null);
        String r = (String) runner.execute(exp, null, null, false, true);
        System.out.println(r);
    }

    /**
     * 使用别名
     *
     * @throws Exception if any
     */
    @Test
    public void testAlias() throws Exception {
        String exp = "cust.setName(\"小强\");" +
                "定义别名 custName cust.name;" +
                "return custName;";
        IExpressContext<String, Object> expressContext = new DefaultContext<>();
        User user = new User();
        user.setName("1");
        expressContext.put("cust", user);
        ExpressRunner runner = new ExpressRunner();
        //
        runner.addOperatorWithAlias("定义别名", "alias", null);
        //执行表达式，并将结果赋给r
        String r = (String) runner.execute(exp, expressContext, null, false, true);
        System.out.println(r);
    }

    @Test
    public void testMacro() throws Exception {
        String exp = "cust.setName(\"小强\");" +
                "定义宏 custName {cust.name};" +
                "return custName;";
        IExpressContext<String, Object> expressContext = new DefaultContext<>();
        User user = new User();
        user.setName("1");
        expressContext.put("cust", user);
        ExpressRunner runner = new ExpressRunner();
        runner.addOperatorWithAlias("定义宏", "macro", null);
        String r = (String) runner.execute(exp, expressContext, null, false, true);
        log.debug("{}", r);
    }

}
