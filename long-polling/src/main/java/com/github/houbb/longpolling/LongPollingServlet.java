/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 * Copyright (c) 2012-2018. houbinbin Inc.
 * tech-validation All rights reserved.
 */

package com.github.houbb.longpolling;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p> </p>
 *
 * <pre> Created: 2018/5/29 上午9:48  </pre>
 * <pre> Project: tech-validation  </pre>
 *
 * @author houbinbin
 * @version 1.0
 * @since JDK 1.7
 */
@WebServlet("/long-polling")
public class LongPollingServlet extends HttpServlet {

    private static final long serialVersionUID = 8314676438472514116L;

    private Random random = new Random();

    private AtomicLong sequenceId = new AtomicLong();

    private AtomicLong count = new AtomicLong();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        System.out.println("第" + (count.incrementAndGet()) + "次 longpolling");

        int sleepSecends = random.nextInt(5);
        //随机获取等待时间，来通过sleep模拟服务端是否准备好数据

        System.out.println("wait " + sleepSecends + " second");

        try {
            //sleep
            TimeUnit.SECONDS.sleep(sleepSecends);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        PrintWriter out = response.getWriter();
        long value = sequenceId.getAndIncrement();
        out.write(Long.toString(value));
    }

}
