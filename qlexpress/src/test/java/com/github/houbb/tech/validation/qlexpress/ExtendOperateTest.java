/*
 * Copyright (c)  2018. houbinbin Inc.
 * tech-validation All rights reserved.
 */

package com.github.houbb.tech.validation.qlexpress;

import com.github.houbb.tech.validation.qlexpress.operater.JoinOperator;
import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * <p> 操作符 </p>
 *
 * <pre> Created: 2018/6/6 下午6:09  </pre>
 * <pre> Project: tech-validation  </pre>
 *
 * @author houbinbin
 * @version 1.0
 * @since JDK 1.7
 */
public class ExtendOperateTest {

    @Test
    public void replaceKeywordTest() throws Exception {
        ExpressRunner runner = new ExpressRunner();
        runner.addOperatorWithAlias("如果", "if", null);
        runner.addOperatorWithAlias("则", "then", null);
        runner.addOperatorWithAlias("否则", "else", null);

        DefaultContext<String, Object> context = new DefaultContext<>();

        final String express = "如果(1>2){ return 10;} 否则 {return 5;}";
        Object r = runner.execute(express, context, null, true, false);
        Assert.assertEquals(5, r);
    }

    @Test
    public void addOperatorTest() throws Exception {
        ExpressRunner runner = new ExpressRunner();
        DefaultContext<String, Object> context = new DefaultContext<>();
        runner.addOperator("join", new JoinOperator());
        Object r = runner.execute("1 join 2 join 3", context, null, false, false);
        Assert.assertEquals(Arrays.asList(1,2,3), r);
    }

    @Test
    public void replaceOperatorTest() throws Exception {
        ExpressRunner runner = new ExpressRunner();
        DefaultContext<String, Object> context = new DefaultContext<>();
        runner.replaceOperator("+", new JoinOperator());
        Object r = runner.execute("1 + 2 + 3", context, null, false, false);
        Assert.assertEquals(Arrays.asList(1,2,3), r);
    }

    @Test
    public void addFunctionTest() throws Exception {
        ExpressRunner runner = new ExpressRunner();
        DefaultContext<String, Object> context = new DefaultContext<>();
        runner.addFunction("join",new JoinOperator());
        Object r = runner.execute("join(1, 2, 3)", context, null, false, false);
        Assert.assertEquals(Arrays.asList(1,2,3), r);
    }

}
