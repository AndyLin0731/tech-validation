/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 * Copyright (c) 2012-2018. github.houbb Inc.
 * tech-validation All rights reserved.
 */

package com.github.houbb.tech.validation.bean.mapping.mapping;


import com.github.houbb.tech.validation.bean.mapping.dto.UserDto;
import com.github.houbb.tech.validation.bean.mapping.model.User;

import org.dozer.DozerBeanMapperBuilder;
import org.dozer.Mapper;

/**
 * 2018/4/11
 * 默认的映射方式
 * @author houbinbin
 * @version 1.0
 * @since 1.7
 */
public class UserDefaultMapping {

    public static UserDto map(User user) {
        Mapper mapper = DozerBeanMapperBuilder.buildDefault();
        return mapper.map(user, UserDto.class);
    }

    public static UserDto map2(User user) {
        Mapper mapper = DozerBeanMapperBuilder.buildDefault();
        UserDto userDto = new UserDto();
        mapper.map(user, userDto);
        return userDto;
    }

}
