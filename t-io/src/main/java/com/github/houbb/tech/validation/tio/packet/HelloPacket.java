/*
 * Copyright (c)  2018. houbinbin Inc.
 * tech-validation All rights reserved.
 */

package com.github.houbb.tech.validation.tio.packet;

import org.tio.core.intf.Packet;

/**
 * <p> </p>
 *
 * <pre> Created: 2018/6/8 上午8:07  </pre>
 * <pre> Project: tech-validation  </pre>
 *
 * @author houbinbin
 * @version 1.0
 * @since JDK 1.7
 */
public class HelloPacket extends Packet {

    private static final long serialVersionUID = -172060606924066412L;
    //消息头的长度
    public static final int HEADER_LENGHT = 4;
    public static final String CHARSET = "utf-8";
    private byte[] body;

    /**
     * @return the body
     */
    public byte[] getBody() {
        return body;
    }

    /**
     * @param body the body to set
     */
    public void setBody(byte[] body) {
        this.body = body;
    }

}
