/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 * Copyright (c) 2012-2018. haiyi Inc.
 * tech-validation All rights reserved.
 */

package com.github.houbb.tech.validation.fluent.validate.validator.range;

import com.baidu.unbiz.fluentvalidator.ValidationError;
import com.baidu.unbiz.fluentvalidator.Validator;
import com.baidu.unbiz.fluentvalidator.ValidatorContext;
import com.baidu.unbiz.fluentvalidator.ValidatorHandler;

import java.util.List;

/**
 * <p> </p>
 *
 * <pre> Created: 2018-05-02 16:15  </pre>
 * <pre> Project: tech-validation  </pre>
 *
 * @author Administrator
 * @version 1.0
 * @since JDK 1.8
 */
public abstract class AbstractRangeValidator extends ValidatorHandler<Object> implements Validator<Object> {

    /**
     * 类型的字符串列表
     * @return 字符串列表
     */
    protected abstract List<String> rangeList();

    /**
     * TODO: 这里是框架本身设计的缺陷，无法直接获取当前 fieldName
     * @return 范围类型
     */
    protected abstract String rangeType();

    @Override
    public boolean validate(ValidatorContext context, Object o) {
        final String string = String.valueOf(o);
        if(rangeList().contains(string)) {
            return true;
        }

        context.addError(ValidationError.create(String.format("Value must be in range: %s", rangeList()))
                .setErrorCode(0)
                .setField(rangeType())
                .setInvalidValue(o));
        return false;
    }

}
