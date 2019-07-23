package com.ashzd.seckill.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @file: BCryptUtil
 * @author: Ash
 * @date: 2019/7/14 14:53
 * @description:
 * @since:
 **/
public class BCryptUtil {

    private static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public static String encode(String password) {
        return bCryptPasswordEncoder.encode(password);
    }

    public static boolean match(String password, String encodedPassword) {
        return bCryptPasswordEncoder.matches(password, encodedPassword);
    }

}
