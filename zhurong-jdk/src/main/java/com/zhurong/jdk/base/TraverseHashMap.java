/**
 * @Title: TraverseHashMap.java
 * @Package: com.zhurong.jdk.base
 * @author LZG, liuzhongguo@cdvcloud.com
 * Copyright (c) 2020 https://www.yunshicloud.com
 */
package com.zhurong.jdk.base;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @description: 遍历HashMap
 * @author LZG
 * @date 2020年05月27日
 */
public class TraverseHashMap {

    public static void main(String[] args) {
        HashMap<Integer, String> testHashMap = new HashMap<>();
        testHashMap.put(1, "西门吹雪");
        testHashMap.put(2, "令狐冲");
        testHashMap.put(3, "凤火连城");
        testHashMap.put(4, "聂风");

        Iterator<Map.Entry<Integer, String>> iterator = testHashMap.entrySet().iterator();

        while(iterator.hasNext()) {
            Map.Entry<Integer, String> next = iterator.next();
            System.out.println(next.getKey() + " - " + next.getValue());
        }
    }

}