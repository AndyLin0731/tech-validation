/*
 * Copyright (c)  2018. houbinbin Inc.
 * tech-validation All rights reserved.
 */

package com.github.houbb.tech.validation.aviator;

import com.googlecode.aviator.AviatorEvaluator;

import java.util.HashMap;
import java.util.Map;

/**
 * <p> </p>
 *
 * <pre> Created: 2018/6/8 下午1:37  </pre>
 * <pre> Project: tech-validation  </pre>
 *
 * @author houbinbin
 * @version 1.0
 * @since JDK 1.7
 */
public class HelloAviator {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        Map<String, Object> env = new HashMap<>(1);
        env.put("a", a);

        AviatorEvaluator.execute("1 + 2 + 3");
        AviatorEvaluator.execute("a[1] + 100", env);
        AviatorEvaluator.execute("'a[1]=' + a[1]", env);
        //求数组长度
        AviatorEvaluator.execute("count(a)", env);
        //求数组总和
        AviatorEvaluator.execute("reduce(a, +, 0)", env);
        //检测数组每个元素都在 0 <= e < 10 之间。
        AviatorEvaluator.execute("seq.every(a, seq.and(seq.ge(0), seq.lt(10)))", env);
    }

}
