/*
 * Copyright (c)  2018. houbinbin Inc.
 * tech-validation All rights reserved.
 */

package com.github.houbb.hystrix.hello;

import java.util.concurrent.Future;

import rx.Observable;
import rx.functions.Action1;

/**
 * <p> </p>
 *
 * <pre> Created: 2018/8/19 下午3:17  </pre>
 * <pre> Project: tech-validation  </pre>
 *
 * @author houbinbin
 * @version 1.0
 * @since JDK 1.7
 */
public class Main {

    public static void main(String[] args) {
        Observable<String> ho = new CommandHelloWorld("World").observe();
        // or Observable<String> co = new CommandHelloWorld("World").toObservable();
        ho.subscribe(new Action1<String>() {

            @Override
            public void call(String s) {
                System.out.println("执行结果: " + s);
                // value emitted here
            }

        });
    }

}
