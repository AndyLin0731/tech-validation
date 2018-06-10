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
 * <p> 集合 </p>
 *
 * @author houbinbin
 * @version 1.0
 * @since JDK 1.7
 */
public class CollectionTest {

    /**
     * set 集合测试
     * 备注：集合的快捷写法
     * @throws Exception if any
     */
    @Test
    public void shorthandTest() throws Exception {
        ExpressRunner runner = new ExpressRunner(false,false);
        DefaultContext<String, Object> context = new DefaultContext<>();
        String express = "abc = NewMap(1:1,2:2); return abc.get(1) + abc.get(2);";
        Object r = runner.execute(express, context, null, false, false);
        Assert.assertEquals(3, r);

        express = "abc = NewList(1,2,3); return abc.get(1)+abc.get(2)";
        r = runner.execute(express, context, null, false, false);
        Assert.assertEquals(5, r);

        express = "abc = [1,2,3]; return abc[1]+abc[2];";
        r = runner.execute(express, context, null, false, false);
        Assert.assertEquals(5, r);
    }

    /**
     * 遍历测试
     * 其实类似java的语法，只是ql不支持for(obj:list){}的语法，只能通过下标访问。
     */
    @Test
    public void foreachTest() throws Exception {
        ExpressRunner runner = new ExpressRunner(false,false);
        DefaultContext<String, Object> context = new DefaultContext<>();
        String express =
                "  Map map = new HashMap();\n" +
                "  map.put(\"a\", \"a_value\");\n" +
                "  map.put(\"b\", \"b_value\");\n" +
                "  keySet = map.keySet();\n" +
                "  objArr = keySet.toArray();\n" +
                "  for (i=0;i<objArr.length;i++) {\n" +
                "  key = objArr[i];\n" +
                "   System.out.println(map.get(key));\n" +
                "  }";
        Object r = runner.execute(express, context, null, false, false);
        System.out.println(r);
    }

}
