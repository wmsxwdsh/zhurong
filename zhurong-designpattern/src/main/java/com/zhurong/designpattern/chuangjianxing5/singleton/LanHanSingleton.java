/**   
 * @Title: LanHanSingleton.java
 * @Package: com.zhurong.designpattern.chuangjianxing5.singleton
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 北京艾森思科技有限公司
 */
package com.zhurong.designpattern.chuangjianxing5.singleton;

/**
 * @description: 懒汉单例 --使用的时候才去创建。
 *          --懒汉式的实现是线程安全的，但整个方法的访问效率低。于是就有了“双重检索锁单例”。
 * @author LZG
 * @date 2019/3/18
 */
public class LanHanSingleton {

    private static LanHanSingleton lanHanSingleton = null;

    //synchronized处理多线程的情况
    public static synchronized LanHanSingleton getInstance() {

        if(null == lanHanSingleton) {
            lanHanSingleton = new LanHanSingleton();
        }

        return lanHanSingleton;
    }

}