/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 * Copyright (c) 2012-2018. houbinbin Inc.
 * tech-validation All rights reserved.
 */

package com.github.houbb.forname;

import org.junit.Test;

import java.util.ServiceLoader;

/**
 * <p> </p>
 *
 * <pre> Created: 2018/5/27 上午11:06  </pre>
 * <pre> Project: tech-validation  </pre>
 *
 * @author houbinbin
 * @version 1.0
 * @since JDK 1.7
 */
public class SayTest {

    @Test
    public void spiTest() {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        ServiceLoader<Say> loader = ServiceLoader.load(Say.class, classLoader);

        for (Say say : loader) {
            say.say();
        }
    }

}
