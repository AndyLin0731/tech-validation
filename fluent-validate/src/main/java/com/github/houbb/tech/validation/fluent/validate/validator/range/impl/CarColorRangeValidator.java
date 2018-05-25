/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 * Copyright (c) 2012-2018. haiyi Inc.
 * tech-validation All rights reserved.
 */

package com.github.houbb.tech.validation.fluent.validate.validator.range.impl;

import com.github.houbb.tech.validation.fluent.validate.constant.ColorEnum;
import com.github.houbb.tech.validation.fluent.validate.validator.range.AbstractRangeValidator;

import java.util.LinkedList;
import java.util.List;

/**
 * <p> </p>
 *
 * <pre> Created: 2018/5/25 下午2:55  </pre>
 * <pre> Project: tech-validation  </pre>
 *
 * @author houbinbin
 * @version 1.0
 * @since JDK 1.7
 */
public class CarColorRangeValidator extends AbstractRangeValidator {
    @Override
    protected List<String> rangeList() {
        List<String> strings = new LinkedList<>();
        for(ColorEnum entry : ColorEnum.values()) {
            strings.add(String.valueOf(entry.name()));
        }
        return strings;
    }

    @Override
    protected String rangeType() {
        return "color";
    }
}
