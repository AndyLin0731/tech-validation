/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 * Copyright (c) 2012-2018. github.houbb Inc.
 * tech-validation All rights reserved.
 */

package com.github.houbb.tech.validation.fluent.validate;

import com.github.houbb.tech.validation.fluent.validate.model.Car;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 * <p> </p>
 *
 * <pre> Created: 2018-04-28 10:08  </pre>
 * <pre> Project: i2_tech  </pre>
 *
 * @author Administrator
 * @version 1.0
 * @since JDK 1.8
 */
public class CarHibernateTest {

    private static Validator validator;

    @BeforeClass
    public static void setUpValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }


    @Test
    public void HibernateValidTest() {
        Car car = Car.builder().build();
        Set<ConstraintViolation<Car>> constraintViolations =
                validator.validate( car );
        System.out.println(constraintViolations);
    }

}
