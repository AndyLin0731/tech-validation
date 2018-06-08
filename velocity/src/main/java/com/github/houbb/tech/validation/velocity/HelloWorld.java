/*
 * Copyright (c)  2018. houbinbin Inc.
 * tech-validation All rights reserved.
 */

package com.github.houbb.tech.validation.velocity;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.util.Properties;

/**
 * <p> </p>
 *
 * <pre> Created: 2018/6/8 下午4:07  </pre>
 * <pre> Project: tech-validation  </pre>
 *
 * @author houbinbin
 * @version 1.0
 * @since JDK 1.7
 */
public class HelloWorld {

    public static void main(String[] args) {
        Properties pro = new Properties();
        pro.setProperty(Velocity.OUTPUT_ENCODING, "UTF-8");
        pro.setProperty(Velocity.INPUT_ENCODING, "UTF-8");
        pro.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        pro.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());

        VelocityEngine ve = new VelocityEngine(pro);
        ve.init();

        Template t = ve.getTemplate("hello.vm");
        VelocityContext ctx = new VelocityContext();
        ctx.put("name", "ryo");

        //1. 输出到命令行
        outputToConsole(t, ctx);

        //2. 输出为文件
        outputToFile(t, ctx);
    }

    /**
     * 输出到命令行
     *
     * @param template 模板
     * @param ctx      上下文
     */
    private static void outputToConsole(Template template, VelocityContext ctx) {
        StringWriter sw = new StringWriter();
        template.merge(ctx, sw);

        System.out.println(sw.toString());
    }

    /**
     * 输出成为文件
     *
     * @param template 模板
     * @param ctx      上下文
     */
    private static void outputToFile(Template template, VelocityContext ctx) {
        final String targetFile = "hello.txt";
        try (FileOutputStream outStream = new FileOutputStream(targetFile);
             OutputStreamWriter writer = new OutputStreamWriter(outStream, "UTF-8");
             BufferedWriter sw = new BufferedWriter(writer)) {

            template.merge(ctx, sw);
            sw.flush();
            System.out.println("目标文件生成完成：" + targetFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
