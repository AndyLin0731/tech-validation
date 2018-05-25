/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 * Copyright (c) 2012-2018. github.houbb Inc.
 * tech-validation All rights reserved.
 */

package com.github.houbb.tech.validation.bean.mapping.vo;


import com.github.houbb.tech.validation.bean.mapping.constant.StatusEnum;

import lombok.Data;

/**
 * 2018/4/11
 *
 * @author houbinbin
 * @version 1.0
 * @since 1.7
 */
@Data
public class UserStatusTarget {

    private String nameVo;

    private String passwordVo;

    private StatusEnum status;


}
