/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 * Copyright (c) 2012-2018. haiyi Inc.
 * tech-validation All rights reserved.
 */

package com.github.houbb.forname.impl;

import com.github.houbb.forname.Say;

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
public class DefaultSay implements Say {

    @Override
    public void say() {
        System.out.println("Default say");
    }

}
