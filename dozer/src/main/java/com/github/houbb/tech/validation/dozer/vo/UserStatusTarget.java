/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 * Copyright (c) 2012-2018. github.houbb Inc.
 * tech-validation All rights reserved.
 */

package com.github.houbb.tech.validation.dozer.vo;


import com.github.houbb.tech.validation.dozer.constant.StatusEnum;

/**
 * 2018/4/11
 *
 * @author houbinbin
 * @version 1.0
 * @since 1.7
 */
public class UserStatusTarget {

    private String nameVo;

    private String passwordVo;

    private StatusEnum status;

    public String getNameVo() {
        return nameVo;
    }

    public void setNameVo(String nameVo) {
        this.nameVo = nameVo;
    }

    public String getPasswordVo() {
        return passwordVo;
    }

    public void setPasswordVo(String passwordVo) {
        this.passwordVo = passwordVo;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserStatusTarget{");
        sb.append("nameVo='").append(nameVo).append('\'');
        sb.append(", passwordVo='").append(passwordVo).append('\'');
        sb.append(", status=").append(status);
        sb.append('}');
        return sb.toString();
    }
}
