package com.ashzd.seckill.util;

import org.springframework.util.DigestUtils;

/**
 * @file: MD5Util
 * @author: Ash
 * @date: 2019/8/30 23:54
 * @description:
 * @since:
 */
public class MD5Util {

    public static String encrypt(String str) {
        return DigestUtils.md5DigestAsHex(str.getBytes());
    }
}
