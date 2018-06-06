/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 * Copyright (c) 2012-2018. haiyi Inc.
 * tech-validation All rights reserved.
 */

package com.github.houbb.tech.validation.qlexpress;

import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;

/**
 * <p> </p>
 *
 * <pre> Created: 2018/5/31 上午9:49  </pre>
 * <pre> Project: tech-validation  </pre>
 *
 * @author houbinbin
 * @version 1.0
 * @since JDK 1.7
 */
public class HelloWorld {

    public static void main(String[] args) throws Exception {
        ExpressRunner runner = new ExpressRunner();
        DefaultContext<String, Object> context = new DefaultContext<>();
        context.put("a", 1);
        context.put("b", 2);
        String express = "a+b";
        Object r = runner.execute(express, context, null, true, false);
        System.out.println(r);
    }

}
