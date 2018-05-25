/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 * Copyright (c) 2012-2018. github.houbb Inc.
 * tech-validation All rights reserved.
 */

package com.github.houbb.tech.validation.fluent.validate;

import com.baidu.unbiz.fluentvalidator.FluentValidator;
import com.baidu.unbiz.fluentvalidator.Result;
import com.baidu.unbiz.fluentvalidator.jsr303.HibernateSupportedValidator;
import com.github.houbb.tech.validation.fluent.validate.model.Car;

import org.junit.Test;

import java.util.Locale;

import javax.validation.Validation;
import javax.validation.ValidatorFactory;

import static com.baidu.unbiz.fluentvalidator.ResultCollectors.toSimple;

/**
 * <p> </p>
 *
 * <pre> Created: 2018-04-28 10:08  </pre>
 * <pre> Project: i2_tech  </pre>
 *
 * Fluent Hibernate 进行整合
 * @author Administrator
 * @version 1.0
 * @since JDK 1.8
 */
public class CarFluentHibernateTest {

    @Test
    public void FluentHibernateValidTest() {
        Locale.setDefault(Locale.CHINA); // speicify language
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        javax.validation.Validator validator = factory.getValidator();

        Car car = Car.builder().build();
        Result result = FluentValidator.checkAll()
                .on(car, new HibernateSupportedValidator<Car>().setHiberanteValidator(validator))
                .doValidate().result(toSimple());
        System.out.println(result);
    }

}
