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
 * xml 映射方式
 * @author houbinbin
 * @version 1.0
 * @since 1.7
 */
public class UserXmlMapping {

    /**
     * 可以借助 spring 声明为单例子
     * @param userDto
     * @return
     */
    public static UserVo map(UserDto userDto) {
        Mapper mapper = DozerBeanMapperBuilder.create()
                .withMappingFiles("UserDto_UserVo_Mapping.xml")
                .build();

        return mapper.map(userDto, UserVo.class);
    }

}
