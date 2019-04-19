/**
 * @Title: StringUtil.java
 * @Package: com.zhurong.utils.general
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2018 https://onezg.cnblogs.com
 */
package com.zhurong.utils.general;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @description: String工具类
 * @author LZG
 * @date 2018/8/24
 */
public class StringUtil {

    public final static String FILE_SEPARATOR = File.separator;

    public final static String DOT = ".";

    /**
     * @Description: 判断字符串是否为空或长度为0或由空白符(Whitespace)构成
     *      StringUtil.isBlank(null)      = true
     *      StringUtil.isBlank("")        = true
     *      StringUtil.isBlank(" ")       = true
     *      StringUtil.isBlank("bob")     = false
     *      StringUtil.isBlank("  bob  ") = false
     * @param str
     * @return boolean
     * @author LZG
     * @date 2018/8/24
     */
    public static boolean isBlank(final String str) {
        int strLen;
        if (str == null || (strLen = str.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if (Character.isWhitespace(str.charAt(i)) == false) {
                return false;
            }
        }
        return true;
    }

    /**
     * @Description: 参考isBlank();
     * @param str
     * @return boolean
     * @author LZG
     * @date 2018/8/24
     */
    public static boolean isNotBlank(final String str) {
        return !StringUtil.isBlank(str);
    }

    /**
     * @Description: 判断字符串是否为空，为空的标准str=null或str.length=0
     *      StringUtil.isEmpty(null)      = true
     *      StringUtil.isEmpty("")        = true
     *      StringUtil.isEmpty(" ")       = false
     *      StringUtil.isEmpty("bob")     = false
     *      StringUtil.isEmpty("  bob  ") = false
     * @param str
     * @return boolean
     * @author LZG
     * @date 2018/8/24
     */
    public static boolean isEmpty(final String str) {
        return str == null || str.length() == 0;
    }

    /**
     * @Description: 参考isEmpty();
     * @param str
     * @return boolean
     * @author LZG
     * @date 2018/8/24
     */
    public static boolean isNotEmpty(final String str) {
        return !StringUtil.isEmpty(str);
    }

    /**
     * @Description: 去除字符串左边和右边的空格
     *      StringUtil.trim(null)          = null
     *      StringUtil.trim("")            = ""
     *      StringUtil.trim("     ")       = ""
     *      StringUtil.trim("abc")         = "abc"
     *      StringUtil.trim("    abc    ") = "abc"
     * @param str
     * @return java.lang.String
     * @author LZG
     * @date 2018/8/24
     */
    public static String trim(final String str) {
        return str == null ? null : str.trim();
    }

    /**
     * @Description: 比较两个字符串是否相等
     * @param str1
     * @param str2
     * @param ignoreCase 是否忽略大小写
     * @return boolean
     * @author LZG
     * @date 2018/8/24
     */
    public static boolean equals(String str1, String str2, boolean ignoreCase) {
        if (null == str1) {
            // 只有两个都为null才判断相等
            return str2 == null;
        }
        if (null == str2) {
            // 字符串2空，字符串1非空，直接false
            return false;
        }

        if (ignoreCase) {
            return str1.toString().equalsIgnoreCase(str2.toString());
        } else {
            return str1.equals(str2);
        }
    }

    /**
     * @Description: 字符串指定区间内字符替换为固定字符
     *      适用场景：
     *          1、身份证展示给用户看，屏蔽中间的几位
     *          2、手机号码展示给用户看，屏蔽中间的几位
     * @param str
     * @param startInclude 开始位置(包含)
     * @param endExclude 结束位置(不包含)
     * @param replacedChar 被替换的字符串
     * @return java.lang.String
     * @author LZG
     * @date 2018/8/24
     */
    public static String replace(String str, int startInclude, int endExclude, char replacedChar) {
        if (isEmpty(str)) {
            return str.toString();
        }
        final int strLength = str.length();
        if (startInclude > strLength) {
            return str.toString();
        }
        if (endExclude > strLength) {
            endExclude = strLength;
        }
        if (startInclude > endExclude) {
            // 如果起始位置大于结束位置，不替换
            return str.toString();
        }

        final char[] chars = new char[strLength];
        for (int i = 0; i < strLength; i++) {
            if (i >= startInclude && i < endExclude) {
                chars[i] = replacedChar;
            } else {
                chars[i] = str.charAt(i);
            }
        }
        return new String(chars);
    }

    /**
     * @Description: 去除下划线，并且下划线后面的字母变成大写（本身是大写则不变）
     * @param str
     * @return java.lang.String
     * @author LZG
     * @date 2019/3/27
     */
    public static String replaceUnderLine(String str) {
        StringBuffer sb = new StringBuffer();
        sb.append(str);
        int count = sb.indexOf("_");

        while (count != 0) {
            int num = sb.indexOf("_", count);
            count = num + 1;
            if (num != -1) {
                char ss = sb.charAt(count);
                if(Character.isUpperCase(ss))
                    continue;

                char ia = (char) (ss - 32);
                sb.replace(count, count + 1, ia + "");
            }
        }
        String result = sb.toString().replaceAll("_", "");
        return result;
    }

    /**
     * @Description: 将包名转换成路径
     * @param packagePath
     * @return java.lang.String
     * @author LZG
     * @date 2019/3/27
     */
    public static String package2path(String packagePath) {
        return packagePath.replaceAll("\\.", "\\\\");
    }

    /**
     * @Description: 将大写字母转换为下划线
     * @param param
     * @return java.lang.String
     * @author LZG
     * @date 2019/3/27
     */
    public static String upperCharToUnderLine(String param) {

        Pattern p = Pattern.compile("[A-Z]");
        if (param == null || param.equals("")) {
            return "";
        }
        StringBuilder builder = new StringBuilder(param);
        Matcher mc = p.matcher(param);
        int i = 0;
        while (mc.find()) {
            builder.replace(mc.start() + i, mc.end() + i, "_" + mc.group().toLowerCase());
            i++;
        }

        if ('_' == builder.charAt(0)) {
            builder.deleteCharAt(0);
        }
        return builder.toString();
    }


}