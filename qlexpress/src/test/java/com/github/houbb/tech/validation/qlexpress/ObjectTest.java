/*
 * Copyright (c)  2018. houbinbin Inc.
 * tech-validation All rights reserved.
 */

package com.github.houbb.tech.validation.qlexpress;

import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;
import com.ql.util.express.IExpressContext;

import org.junit.Assert;
import org.junit.Test;

/**
 * <p> 对象测试 </p>
 *
 * 备注：例子来自官方例子
 *
 * <pre> Created: 2018/6/6 下午6:09  </pre>
 * <pre> Project: tech-validation  </pre>
 *
 * @author houbinbin
 * @version 1.0
 * @since JDK 1.7
 */
public class ObjectTest {

    @Test
    public void test1() throws Exception {
        String exp = "import com.github.houbb.tech.validation.qlexpress.User;" +
                "User cust = new User(1);" +
                "cust.setName(\"小强\");" +
                "return cust.getName();";
        ExpressRunner runner = new ExpressRunner();
        String r = (String) runner.execute(exp, null, null, false, false);
        Assert.assertEquals("操作符执行错误", "小强", r);
    }

    @Test
    public void test2() throws Exception {
        String exp = "cust.setName(\"小强\");" +
                "return cust.getName();";
        IExpressContext<String, Object> expressContext = new DefaultContext<>();
        expressContext.put("cust", new User(1));
        ExpressRunner runner = new ExpressRunner();
        String r = (String) runner.execute(exp, expressContext, null, false, false);
        Assert.assertEquals("操作符执行错误", "小强", r);
    }

    @Test
    public void test3() throws Exception {
        String exp = "首字母大写(\"abcd\")";
        ExpressRunner runner = new ExpressRunner();
        runner.addFunctionOfClassMethod("首字母大写", User.class.getName(), "firstToUpper", new String[]{"String"}, null);
        String r = (String) runner.execute(exp, null, null, false, false);
        Assert.assertEquals("操作符执行错误", "Abcd", r);
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
        expressContext.put("cust", new User(1));
        ExpressRunner runner = new ExpressRunner();
        //
        runner.addOperatorWithAlias("定义别名", "alias", null);
        //执行表达式，并将结果赋给r
        String r = (String) runner.execute(exp, expressContext, null, false, false);
        Assert.assertEquals("操作符执行错误", "小强", r);
    }

    /**
     * 使用宏
     *
     * @throws Exception if any
     */
    @Test
    public void testMacro() throws Exception {
        String exp = "cust.setName(\"小强\");" +
                "定义宏 custName {cust.name};" +
                "return custName;";
        IExpressContext<String, Object> expressContext = new DefaultContext<>();
        expressContext.put("cust", new User(1));
        ExpressRunner runner = new ExpressRunner();
        runner.addOperatorWithAlias("定义宏", "macro", null);
        String r = (String) runner.execute(exp, expressContext, null, false, false);
        Assert.assertEquals("操作符执行错误", "小强", r);
    }


}
