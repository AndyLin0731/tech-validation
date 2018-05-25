/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 * Copyright (c) 2012-2018. github.houbb Inc.
 * tech-validation All rights reserved.
 */

package com.github.houbb.tech.validation.dozer.vo;

/**
 * 2018/4/11
 *
 * @author houbinbin
 * @version 1.0
 * @since 1.7
 */
public class UserStatusSource {

    private String nameVo;

    private String passwordVo;

    private String status;

    public UserStatusSource(String nameVo, String passwordVo, String status) {
        this.nameVo = nameVo;
        this.passwordVo = passwordVo;
        this.status = status;
    }

    public static void main(String[] args) {
        UserStatusSource source = new UserStatusSource("name", "password", "1");
//        Mapper mapper = new DozerBeanMapper();
    }
}
