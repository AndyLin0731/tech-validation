/*
 * Copyright (c)  2018. houbinbin Inc.
 * tech-validation All rights reserved.
 */

package com.github.houbb.tech.validation.reflect.interfaces.impl;

import com.github.houbb.tech.validation.reflect.interfaces.ITag;

/**
 * <p> </p>
 *
 * <pre> Created: 2018/8/16 下午3:24  </pre>
 * <pre> Project: tech-validation  </pre>
 *
 * @author houbinbin
 * @version 1.0
 * @since JDK 1.7
 */
public class BadTag implements ITag {

    @Override
    public String name() {
        return "bad";
    }

}
