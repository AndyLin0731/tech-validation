/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 * Copyright (c) 2012-2018. github.houbb Inc.
 * tech-validation All rights reserved.
 */

package com.github.houbb.tech.validation.fluent.validate.validator;

import com.baidu.unbiz.fluentvalidator.Validator;
import com.baidu.unbiz.fluentvalidator.ValidatorContext;
import com.baidu.unbiz.fluentvalidator.ValidatorHandler;

/**
 * <p> </p>
 *
 * <pre> Created: 2018-04-28 10:25  </pre>
 * <pre> Project: i2_tech  </pre>
 *
 * @author Administrator
 * @version 1.0
 * @since JDK 1.8
 */
public class CarSeatCountValidator extends ValidatorHandler<Integer> implements Validator<Integer> {

    @Override
    public boolean validate(ValidatorContext context, Integer integer) {
        if (integer < 2) {
            //添加属性测试
            context.setAttribute("seatCount", 2);
            context.addErrorMsg(String.format("Seat count is not valid, invalid value=%s", integer));
            return false;
        }
        return true;
    }

}
