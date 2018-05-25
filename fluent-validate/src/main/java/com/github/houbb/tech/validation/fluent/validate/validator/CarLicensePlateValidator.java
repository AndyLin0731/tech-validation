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
 * <pre> Created: 2018-04-28 10:29  </pre>
 * <pre> Project: i2_tech  </pre>
 *
 * @author Administrator
 * @version 1.0
 * @since JDK 1.8
 */
public class CarLicensePlateValidator extends ValidatorHandler<String> implements Validator<String> {

    @Override
    public boolean validate(ValidatorContext context, String s) {
        System.out.println(context.getAttribute("seatCount"));
        try {
            Integer integer = Integer.valueOf(s);
            if(integer > 14 || integer < 2) {
                context.addErrorMsg(String.format("LicensePlate must in [2, 14], invalid value=%s", s));
            }
            return true;
        } catch (NumberFormatException e) {
            context.addErrorMsg(String.format("LicensePlate is not a number, invalid value=%s", s));
            return false;
        }
    }

}
