/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 * Copyright (c) 2012-2018. haiyi Inc.
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
public class SingTest {

    @Test
    public void spiTest() {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        ServiceLoader<Sing> loader = ServiceLoader.load(Sing.class, classLoader);

        for (Sing sing : loader) {
            sing.sing();
        }
    }

}
