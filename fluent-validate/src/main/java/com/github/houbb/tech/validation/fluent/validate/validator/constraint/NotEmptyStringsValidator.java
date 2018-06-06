/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 * Copyright (c) 2012-2018. houbinbin Inc.
 * tech-validation All rights reserved.
 */

package com.github.houbb.tech.validation.fluent.validate.validator.constraint;


import com.github.houbb.paradise.common.util.CollectionUtil;
import com.github.houbb.paradise.common.util.StringUtil;
import com.github.houbb.tech.validation.fluent.validate.validator.annotation.NotEmptyStrings;

import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


/**
 * <p> 不为空的字符串列表 </p>
 * 1. 此处是一个 example
 * <pre> Created: 2018/5/7 下午4:21  </pre>
 * <pre> Project: tech-validation  </pre>
 *
 * @author houbinbin
 * @version 1.0
 * @since JDK 1.7
 */
public class NotEmptyStringsValidator implements ConstraintValidator<NotEmptyStrings, List<String>> {

    /**
     * 提示消息
     */
    private String message;

    @Override
    public void initialize(NotEmptyStrings constraintAnnotation) {
        message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(List<String> value, ConstraintValidatorContext context) {
        if(CollectionUtil.isEmpty(value)) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(message)
                    .addConstraintViolation();
            return false;
        }

        for(String string : value) {
            if(StringUtil.isEmpty(string)) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate(message)
                        .addConstraintViolation();
                return false;
            }
        }

        return true;
    }

}
