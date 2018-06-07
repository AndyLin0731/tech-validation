/*
 * Copyright (c)  2018. houbinbin Inc.
 * tech-validation All rights reserved.
 */

package com.github.houbb.tech.validation.okhttp;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * <p> </p>
 *
 * <pre> Created: 2018/6/8 上午7:43  </pre>
 * <pre> Project: tech-validation  </pre>
 *
 * @author houbinbin
 * @version 1.0
 * @since JDK 1.7
 */
public class OkHttpGet {

    /**
     * 获取一个 URL 对应的信息
     * @param url 网络地址
     * @return 请求反馈
     * @throws IOException if any
     */
    String get(String url) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    public static void main(String[] args) throws IOException {
        OkHttpGet example = new OkHttpGet();
        String response = example.get("https://raw.github.com/square/okhttp/master/README.md");
        System.out.println(response);
    }

}
