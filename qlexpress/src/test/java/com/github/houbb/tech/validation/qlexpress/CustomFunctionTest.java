/*
 * Copyright (c)  2018. houbinbin Inc.
 * tech-validation All rights reserved.
 */

package com.github.houbb.tech.validation.qlexpress;

import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;

import org.junit.Assert;
import org.junit.Test;

/**
 * <p> 操作符测试 </p>
 *
 * 支持 +,-,*,/,<,>,<=,>=,==,!=,<>【等同于!=】,%,mod【取模等同于%】,++,--,
 * in【类似sql】,like【sql语法】,&&,||,!,等操作符
 * 支持for，break、continue、if then else 等标准的程序控制逻辑
 *
 * <pre> Created: 2018/6/6 下午6:09  </pre>
 * <pre> Project: tech-validation  </pre>
 *
 * @author houbinbin
 * @version 1.0
 * @since JDK 1.7
 */
public class CustomFunctionTest {

    /**
     * 自定义函数测试
     * @throws Exception if any
     */
    @Test
    public void defineFunctionTest() throws Exception {
        final String express = "function add(int a,int b){\n" +
                "  return a+b;\n" +
                "};\n" +
                "\n" +
                "function sub(int a,int b){\n" +
                "  return a - b;\n" +
                "};\n" +
                "\n" +
                "a=10;\n" +
                "return add(a,4) + sub(a,9);";

        ExpressRunner runner = new ExpressRunner();
        DefaultContext<String, Object> context = new DefaultContext<>();
        Object r = runner.execute(express, context, null, true, false);
        Assert.assertEquals(15, r);
    }

}
