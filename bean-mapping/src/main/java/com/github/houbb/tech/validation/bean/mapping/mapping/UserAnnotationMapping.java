/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 * Copyright (c) 2012-2018. github.houbb Inc.
 * tech-validation All rights reserved.
 */

package com.github.houbb.tech.validation.bean.mapping.mapping;


import com.github.houbb.tech.validation.bean.mapping.dto.UserDto;
import com.github.houbb.tech.validation.bean.mapping.vo.UserVo;

import org.dozer.DozerBeanMapperBuilder;
import org.dozer.Mapper;

/**
 * 2018/4/11
 * 注解 映射方式
 * @author houbinbin
 * @version 1.0
 * @since 1.7
 */
public class UserAnnotationMapping {

    public static UserVo map(UserDto userDto) {
        Mapper mapper = DozerBeanMapperBuilder.create().build();
        return mapper.map(userDto, UserVo.class);
    }

}
