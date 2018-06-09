/*
 * Copyright (c)  2018. houbinbin Inc.
 * tech-validation All rights reserved.
 */

package com.github.houbb.tech.validation.qlexpress;

import com.github.houbb.tech.validation.qlexpress.operater.JoinOperator;
import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;

import org.junit.Test;

/**
 * <p> </p>
 *
 * <pre> Created: 2018/6/9 下午5:27  </pre>
 * <pre> Project: tech-validation  </pre>
 *
 * @author houbinbin
 * @version 1.0
 * @since JDK 1.7
 */
public class BindObjectMethodTest {

    @Test
    public void bindObjectMethodTest() throws Exception {
        ExpressRunner runner = new ExpressRunner();
        DefaultContext<String, Object> context = new DefaultContext<>();
        
        runner.addFunctionOfClassMethod("取绝对值", Math.class.getName(), "abs",
                new String[] { "double" }, null);
        runner.addFunctionOfClassMethod("转换为大写", BindObjectMethod.class.getName(),
                "upper", new String[] { "String" }, null);

        runner.addFunctionOfServiceMethod("打印", System.out, "println",new String[] { "String" }, null);
        runner.addFunctionOfServiceMethod("contains", new BindObjectMethod(), "anyContains",
                new Class[] { String.class, String.class }, null);

        String exp = "取绝对值(-100);转换为大写(\"hello world\");打印(\"你好吗？\");contains(\"helloworld\",\"aeiou\")";
        Object r = runner.execute(exp, context, null, false, false);
        System.out.println(r);
    }

}
