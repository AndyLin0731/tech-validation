/*
 * Copyright (c)  2018. houbinbin Inc.
 * tech-validation All rights reserved.
 */

package com.github.houbb.tech.validation.qlexpress;

import com.ql.util.express.DefaultContext;
import com.ql.util.express.DynamicParamsUtil;
import com.ql.util.express.ExpressRunner;
import com.ql.util.express.IExpressContext;

import org.junit.Assert;
import org.junit.Test;

/**
 * <p> 可变参数 </p>
 *
 * @author houbinbin
 * @version 1.0
 * @since JDK 1.7
 */
public class DynamicVarTest {

    /**
     * 获取模板
     * 备注: 等价于getTemplate(Object[] params)
     * @param params 参数
     * @return 结果
     * @throws Exception if any
     */
    public Object getTemplate(Object... params) throws Exception{
        StringBuilder result = new StringBuilder();
        for(Object obj:params){
            result.append(obj).append(",");
        }
        return result.toString();
    }

    /**
     * 动态参数测试
     * @throws Exception if any
     */
    @Test
    public void dynamicVarTest() throws Exception {
        ExpressRunner runner = new ExpressRunner();
        IExpressContext<String,Object> expressContext = new DefaultContext<>();
        runner.addFunctionOfServiceMethod("getTemplate", this, "getTemplate", new Class[]{Object[].class}, null);

        //(1)默认的不定参数可以使用数组来代替
        Object r = runner.execute("getTemplate([11,'22',33L,true])", expressContext, null,false, false);
        Assert.assertEquals("11,22,33,true,", r);
        //(2)像java一样,支持函数动态参数调用,需要打开以下全局开关,否则以下调用会失败
        DynamicParamsUtil.supportDynamicParams = true;
        r = runner.execute("getTemplate(11,'22',33L,true)", expressContext, null,false, false);
        Assert.assertEquals("11,22,33,true,", r);
    }

}
