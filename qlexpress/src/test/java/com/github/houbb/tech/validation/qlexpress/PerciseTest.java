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

import java.util.ArrayList;
import java.util.List;

/**
 * <p> 精度测试 </p>
 *
 * <pre> Created: 2018/6/9 下午5:27  </pre>
 * <pre> Project: tech-validation  </pre>
 *
 * @author houbinbin
 * @version 1.0
 * @since JDK 1.7
 */
public class PerciseTest {

    /**
     * 测试精度设置
     * @throws Exception if any
     */
    @Test
    public void testPercise() throws Exception {
        ExpressRunner runner = new ExpressRunner(true, false);
        IExpressContext<String,Object> expressContext = new DefaultContext<>();
        String expression ="12.3/3";
        Object result = runner.execute(expression, expressContext, null, false, false);
        System.out.println(result);
    }

    /**
     * 测试非精度
     * @throws Exception if any
     */
    @Test
    public void testNoPercise() throws Exception {
        ExpressRunner runner = new ExpressRunner(false, false);
        IExpressContext<String,Object> expressContext = new DefaultContext<>();
        String expression ="12.3/3";
        Object result = runner.execute(expression, expressContext, null, false, false);
        System.out.println(result);
    }

}
