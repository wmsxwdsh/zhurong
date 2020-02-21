/**
 * @Title: TestSynchronized.java
 * @Package: com.zhurong.concurrency.zhanglong
 * @author LZG, liuzhongguo@cdvcloud.com
 * Copyright (c) 2020 https://www.yunshicloud.com
 */
package com.zhurong.concurrency.zhanglong;

/**
 * @description:
 * @author LZG
 * @date 2020年02月21日
 */
public class TestSynchronized {

    public synchronized void method1() {

    }

    public static synchronized void method2() {

    }

}

/**
 * TestSynchronized test1 = new TestSynchronized();
 * 问：线程1执行method1方法，但没有执行完，线程2能执行method2方法吗？
 *
 * 可以。
 * synchronized锁的是当前对象（即test1）
 * static synchronized锁的是当前对象的Class对象
 * 锁的不是同一个对象。
 *
 *
 *
 */