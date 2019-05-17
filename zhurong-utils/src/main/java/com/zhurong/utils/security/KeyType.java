/**
 * @Title: KeyType.java
 * @Package: com.essence.euauth.web.security
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 北京艾森思科技有限公司
 */
package com.zhurong.utils.security;

/**
 * @description: 摘自阿里巴巴KeyUtilApp.jar（已开源）
 * @author LZG
 * @date 2019/5/17
 */
public class KeyType {

    public KeyType(String name, int length) {
        this.name = name;
        this.length = length;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLength() {
        return this.length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public static final KeyType MD5 = new KeyType("MD5", 32);
    public static final KeyType DSA1024 = new KeyType("DSA", 1024);
    public static final KeyType RSA1024 = new KeyType("RSA", 1024);
    public static final KeyType DSA2048 = new KeyType("DSA", 2048);
    public static final KeyType RSA2048 = new KeyType("RSA", 2048);
    private String name;
    private int length;

}