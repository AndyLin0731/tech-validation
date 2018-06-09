/*
 * Copyright (c)  2018. houbinbin Inc.
 * tech-validation All rights reserved.
 */

package com.github.houbb.tech.validation.qlexpress;

/**
 * <p> 绑定对象方法 </p>
 *
 * <pre> Created: 2018/6/9 下午5:27  </pre>
 * <pre> Project: tech-validation  </pre>
 *
 * @author houbinbin
 * @version 1.0
 * @since JDK 1.7
 */
public class BindObjectMethod {

    /**
     * 大写
     * @param abc
     * @return
     */
    public static String upper(String abc) {
        return abc.toUpperCase();
    }

    /**
     * 任何包含
     * @param str
     * @param searchStr
     * @return
     */
    public boolean anyContains(String str, String searchStr) {

        char[] s = str.toCharArray();
        for (char c : s) {
            if (searchStr.contains(c + "")) {
                return true;
            }
        }
        return false;
    }


}
