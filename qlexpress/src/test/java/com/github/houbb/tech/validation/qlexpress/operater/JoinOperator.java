/*
 * Copyright (c)  2018. houbinbin Inc.
 * tech-validation All rights reserved.
 */

package com.github.houbb.tech.validation.qlexpress.operater;

import com.ql.util.express.Operator;

/**
 * <p> </p>
 *
 * <pre> Created: 2018/6/9 下午5:11  </pre>
 * <pre> Project: tech-validation  </pre>
 *
 * @author houbinbin
 * @version 1.0
 * @since JDK 1.7
 */
public class JoinOperator extends Operator {

    @Override
    public Object executeInner(Object[] objects) {
        java.util.List result = new java.util.ArrayList();

        for(Object object : objects) {
            if(object instanceof java.util.List) {
                result.addAll(((java.util.List) object));
            } else {
                result.add(object);
            }
        }

        return result;
    }

}
