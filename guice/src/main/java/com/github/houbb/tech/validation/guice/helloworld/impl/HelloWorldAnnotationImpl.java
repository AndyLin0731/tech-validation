/*
 * Copyright (c)  2018. houbinbin Inc.
 * tech-validation All rights reserved.
 */

package com.github.houbb.tech.validation.guice.helloworld.impl;


import com.github.houbb.tech.validation.guice.helloworld.HelloWorldAnnotation;

/**
 *
 * @author bbhou
 * @date 2017/10/30
 */
public class HelloWorldAnnotationImpl implements HelloWorldAnnotation {
    @Override
    public void hello() {
        System.out.println("Hello World Annotation!");
    }
}
