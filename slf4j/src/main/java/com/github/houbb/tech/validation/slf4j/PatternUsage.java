/*
 * Copyright (c)  2018. houbinbin Inc.
 * tech-validation All rights reserved.
 */

package com.github.houbb.tech.validation.slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p> </p>
 *
 * <pre> Created: 2018/8/27 下午9:32  </pre>
 * <pre> Project: tech-validation  </pre>
 *
 * @author houbinbin
 * @version 1.0
 * @since JDK 1.7
 */
public class PatternUsage {

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(PatternUsage.class);
        logger.info("{} is {} years old", "ryo", 18);
    }

}
