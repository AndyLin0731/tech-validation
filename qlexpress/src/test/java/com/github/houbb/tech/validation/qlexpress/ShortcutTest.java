/*
 * Copyright (c)  2018. houbinbin Inc.
 * tech-validation All rights reserved.
 */

package com.github.houbb.tech.validation.qlexpress;

import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;
import com.ql.util.express.IExpressContext;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * <p> 短路运算符测试 </p>
 *
 * <pre> Created: 2018/6/9 下午5:27  </pre>
 * <pre> Project: tech-validation  </pre>
 *
 * @author houbinbin
 * @version 1.0
 * @since JDK 1.7
 */
public class ShortcutTest {

    private ExpressRunner runner = new ExpressRunner();

    private void initial() throws Exception{
        runner.addOperatorWithAlias("小于","<","$1 小于 $2 不满足期望");
        runner.addOperatorWithAlias("大于",">","$1 大于 $2 不满足期望");
    }

    private boolean calculateLogicTest(String expression, IExpressContext<String, Object> expressContext, List<String> errorInfo) throws Exception {
        return (Boolean)runner.execute(expression, expressContext, errorInfo, true, false);
    }

    /**
     * 测试非短路逻辑,并且输出出错信息
     * @throws Exception if any
     */
    @Test
    public void testShortCircuit() throws Exception {
        runner.setShortCircuit(true);
        IExpressContext<String,Object> expressContext = new DefaultContext<>();
        expressContext.put("违规天数", 100);
        expressContext.put("虚假交易扣分", 11);
        expressContext.put("VIP", false);
        List<String> errorInfo = new ArrayList<>();
        initial();
        String expression ="2 小于 1 and (违规天数 小于 90 or 虚假交易扣分 小于 12)";
        boolean result = calculateLogicTest(expression, expressContext, errorInfo);
        showErrorInfo(result, errorInfo);
    }

    /**
     * 测试非短路逻辑,并且输出出错信息
     * @throws Exception if any
     */
    @Test
    public void testNoShortCircuit() throws Exception {
        runner.setShortCircuit(false);
        IExpressContext<String,Object> expressContext = new DefaultContext<>();
        expressContext.put("违规天数", 100);
        expressContext.put("虚假交易扣分", 11);
        expressContext.put("VIP", false);
        List<String> errorInfo = new ArrayList<>();
        initial();
        String expression ="2 小于 1 and (违规天数 小于 90 or 虚假交易扣分 小于 12)";
        boolean result = calculateLogicTest(expression, expressContext, errorInfo);
        showErrorInfo(result, errorInfo);
    }

    /**
     * 展现错误信息
     * @param result 结果
     * @param errorList 错误列表
     */
    private void showErrorInfo(boolean result, List<String> errorList) {
        if(result){
            System.out.println("result is success!");
        }else{
            System.out.println("result is fail!");
            for(String error : errorList){
                System.out.println(error);
            }
        }
    }


}
