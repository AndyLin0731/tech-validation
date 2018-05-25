/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 * Copyright (c) 2012-2018. github.houbb Inc.
 * tech-validation All rights reserved.
 */

package com.github.houbb.tech.validation.fluent.validate;

import com.baidu.unbiz.fluentvalidator.ComplexResult;
import com.baidu.unbiz.fluentvalidator.FluentValidator;
import com.github.houbb.tech.validation.fluent.validate.model.Car;
import com.github.houbb.tech.validation.fluent.validate.validator.CarLicensePlateValidator;
import com.github.houbb.tech.validation.fluent.validate.validator.CarSeatCountValidator;


import org.junit.Test;

import static com.baidu.unbiz.fluentvalidator.ResultCollectors.toComplex;

/**
 * <p> </p>
 *
 * <pre> Created: 2018-04-28 10:22  </pre>
 * <pre> Project: i2_tech  </pre>
 *
 * @author Administrator
 * @version 1.0
 * @since JDK 1.8
 */
public class CarFluentTest {

    @Test
    public void fluentTest() {
        Car car = Car.builder().build();

        ComplexResult complexResult = FluentValidator
                .checkAll()
                .failOver()
                .on(car.getSeatCount(), new CarSeatCountValidator())
                .on(car.getLicensePlate(), new CarLicensePlateValidator())
                .doValidate()
                .setIsFailFast(false)
                .result(toComplex());
        System.out.println(complexResult);
    }

}
