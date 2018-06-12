package com.github.houbb.tech.validation.guice.helloworld.impl;

import com.google.inject.Guice;
import com.google.inject.Injector;

import com.github.houbb.tech.validation.guice.helloworld.HelloWorldAnnotation;

import org.junit.Test;

/**
* HelloWorldAnnotationImpl Tester.
*
* @author houbinbin
* @since 06/12/2018
* @version 1.0
*/
public class HelloWorldAnnotationImplTest {

    /**
     * 依赖于注解的实现
     * 1. 可以发现相对于 spring，guice 更加的轻量级。
     */
    @Test
    public void helloTest() throws Exception {
        Injector injector = Guice.createInjector();
        HelloWorldAnnotation annotation = injector.getInstance(HelloWorldAnnotation.class);
        annotation.hello();
    }

    
}
