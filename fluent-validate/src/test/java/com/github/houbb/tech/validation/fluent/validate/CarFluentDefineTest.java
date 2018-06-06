/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 * Copyright (c) 2012-2018. houbinbin Inc.
 * tech-validation All rights reserved.
 */

package com.github.houbb.tech.validation.fluent.validate;

import com.alibaba.fastjson.JSON;
import com.baidu.unbiz.fluentvalidator.ComplexResult;
import com.baidu.unbiz.fluentvalidator.FluentValidator;
import com.baidu.unbiz.fluentvalidator.jsr303.HibernateSupportedValidator;
import com.baidu.unbiz.fluentvalidator.registry.impl.SimpleRegistry;
import com.github.houbb.tech.validation.fluent.validate.model.Car;
import com.github.houbb.tech.validation.fluent.validate.validator.CarLicensePlateValidator;
import com.github.houbb.tech.validation.fluent.validate.validator.CarSeatCountValidator;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Locale;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import static com.baidu.unbiz.fluentvalidator.ResultCollectors.toComplex;

/**
 * <p> 自定义测试</p>
 *
 * <pre> Created: 2018-04-28 10:22  </pre>
 * <pre> Project: i2_tech  </pre>
 *
 * @author Administrator
 * @version 1.0
 * @since JDK 1.8
 */
public class CarFluentDefineTest {

    private static Validator validator;

    @BeforeClass
    public static void setUpValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }


    @Test
    public void HibernateValidTest() {
        Car car = Car.builder()
                .color("dd")
                .build();

        Locale.setDefault(Locale.CHINA);
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        ComplexResult result = FluentValidator
                .checkAll()
                .configure(new SimpleRegistry())
                .failOver()
                //1. hibernate 注解
                .on(car, new HibernateSupportedValidator<>().setHiberanteValidator(validator))
                //2. fluent-validate 注解
                .on(car)
                .setIsFailFast(false)
                .doValidate()
                .result(toComplex());
        System.out.println(JSON.toJSON(result));
    }

}
