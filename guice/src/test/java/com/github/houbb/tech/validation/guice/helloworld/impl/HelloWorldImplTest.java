package com.github.houbb.tech.validation.guice.helloworld.impl;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.Scopes;

import com.github.houbb.tech.validation.guice.helloworld.HelloWorld;

import org.junit.Assert;
import org.junit.Test;

/**
 * HelloWorldImpl Tester.
 *
 * @author houbinbin
 * @version 1.0
 * @since 06/12/2018
 */
public class HelloWorldImplTest {


    /**
     * 简单绑定使用
     */
    @Test
    public void helloTest() throws Exception {
        Injector injector = Guice.createInjector(new Module() {
            @Override
            public void configure(Binder binder) {
                binder.bind(HelloWorld.class).to(HelloWorldImpl.class);
            }
        });
        HelloWorld helloWorld = injector.getInstance(HelloWorld.class);
        helloWorld.hello();
    }


    /**
     * 默认创建的不是单例
     */
    @Test
    public void isSingletonTest() {
        Injector injector = Guice.createInjector(new Module() {
            @Override
            public void configure(Binder binder) {
                binder.bind(HelloWorld.class).to(HelloWorldImpl.class);
            }
        });
        HelloWorld helloWorld = injector.getInstance(HelloWorld.class);
        HelloWorld helloWorldTwo = injector.getInstance(HelloWorld.class);
        Assert.assertEquals(helloWorld.hashCode(), helloWorldTwo.hashCode());
    }

    /**
     * 单例
     */
    @Test
    public void singletonTest() {
        Injector injector = Guice.createInjector(new Module() {
            @Override
            public void configure(Binder binder) {
                binder.bind(HelloWorld.class).to(HelloWorldImpl.class).in(Scopes.SINGLETON);
            }
        });
        HelloWorld helloWorld = injector.getInstance(HelloWorld.class);
        HelloWorld helloWorldTwo = injector.getInstance(HelloWorld.class);
        Assert.assertEquals(helloWorld.hashCode(), helloWorldTwo.hashCode());
    }


}
