/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 * Copyright (c) 2012-2018. houbinbin Inc.
 * tech-validation All rights reserved.
 */

package com.github.houbb.forname.impl;

import com.google.auto.service.AutoService;

import com.github.houbb.forname.Sing;

/**
 * <p> </p>
 *
 * <pre> Created: 2018/5/27 上午10:37  </pre>
 * <pre> Project: tech-validation  </pre>
 *
 * @author houbinbin
 * @version 1.0
 * @since JDK 1.7
 */
@AutoService(Sing.class)
public class DefaultSing implements Sing {

    @Override
    public void sing() {
        System.out.println("Sing a song...");
    }

}
