/*
 * Copyright (c)  2018. houbinbin Inc.
 * tech-validation All rights reserved.
 */

package com.github.houbb.tech.validation.guice.helloworld;

import com.google.inject.ImplementedBy;

import com.github.houbb.tech.validation.guice.helloworld.impl.HelloWorldAnnotationImpl;

/**
 *
 * @author bbhou
 * @date 2017/10/30
 */
@ImplementedBy(HelloWorldAnnotationImpl.class)
public interface HelloWorldAnnotation {

    void hello();

}
