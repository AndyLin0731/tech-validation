/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 * Copyright (c) 2012-2018. haiyi Inc.
 * tech-validation All rights reserved.
 */

package com.github.houbb.tech.validation.fluent.validate.validator.annotation;


import com.github.houbb.tech.validation.fluent.validate.validator.constraint.NotEmptyStringsValidator;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * <p> 自定义校验注解 </p>
 * 1. 结合 hibernate 进行使用
 * 2. 下列方法对于 hibernate 本身是必须的
 * <pre> Created: 2018/5/7 下午4:20  </pre>
 * <pre> Project: tech-validation  </pre>
 *
 * @author houbinbin
 * @version 1.0
 * @since JDK 1.7
 */
@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = NotEmptyStringsValidator.class)
@Documented
public @interface NotEmptyStrings {

    String message() default "字符串列表不能为空";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
