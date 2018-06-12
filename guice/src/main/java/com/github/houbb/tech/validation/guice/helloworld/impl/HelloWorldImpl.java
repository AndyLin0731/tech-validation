/*
 * Copyright (c)  2018. houbinbin Inc.
 * tech-validation All rights reserved.
 */

package com.github.houbb.tech.validation.guice.helloworld.impl;


import com.github.houbb.tech.validation.guice.helloworld.HelloWorld;

/**
 *
 * @author bbhou
 * @date 2017/10/30
 */
public class HelloWorldImpl implements HelloWorld {

    @Override
    public void hello() {
        System.out.println("hello world");
    }

}
