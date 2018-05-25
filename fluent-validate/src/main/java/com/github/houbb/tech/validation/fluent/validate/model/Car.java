/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 * Copyright (c) 2012-2018. github.houbb Inc.
 * tech-validation All rights reserved.
 */

package com.github.houbb.tech.validation.fluent.validate.model;

import com.baidu.unbiz.fluentvalidator.annotation.FluentValidate;
import com.github.houbb.tech.validation.fluent.validate.validator.annotation.NotEmptyStrings;
import com.github.houbb.tech.validation.fluent.validate.validator.range.impl.CarColorRangeValidator;

import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Builder;
import lombok.Data;

/**
 * <p> </p>
 *
 * <pre> Created: 2018-04-28 10:06  </pre>
 * <pre> Project: i2_tech  </pre>
 *
 * @author Administrator
 * @version 1.0
 * @since JDK 1.8
 */
@Data
@Builder
public class Car {

    @NotNull
    private String manufacturer;

    @NotNull
    @Size(min = 2, max = 14)
    private String licensePlate;

    @Min(2)
    private int seatCount;

    @NotEmptyStrings
    private List<String> tags;

    @FluentValidate({CarColorRangeValidator.class})
    private String color;

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public int getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
