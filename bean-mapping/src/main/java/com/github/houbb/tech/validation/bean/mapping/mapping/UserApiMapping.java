/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 * Copyright (c) 2012-2018. github.houbb Inc.
 * tech-validation All rights reserved.
 */

package com.github.houbb.tech.validation.bean.mapping.mapping;


import com.github.houbb.tech.validation.bean.mapping.model.User;
import com.github.houbb.tech.validation.bean.mapping.vo.UserVo;

import org.dozer.DozerBeanMapperBuilder;
import org.dozer.Mapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.dozer.loader.api.FieldsMappingOptions;
import org.dozer.loader.api.TypeMappingOptions;

/**
 * 2018/4/11
 * 注解 映射方式
 *
 * @author houbinbin
 * @version 1.0
 * @since 1.7
 */
public class UserApiMapping {

    public static UserVo map(User user) {
        Mapper mapper = DozerBeanMapperBuilder.create()
                .withMappingBuilder(new BeanMappingBuilder() {
                    @Override
                    protected void configure() {
                        mapping(type(User.class).mapEmptyString(true),
                                type(UserVo.class),
                                TypeMappingOptions.wildcardCaseInsensitive(true)
                        ).fields(
                                field("name"),
                                field("nameVo"),
                                FieldsMappingOptions.oneWay()
                        ).fields(
                                field("password"),
                                field("passwordVo"),
                                FieldsMappingOptions.oneWay()
                        );
                    }
                })
                .build();
        return mapper.map(user, UserVo.class);
    }

}
