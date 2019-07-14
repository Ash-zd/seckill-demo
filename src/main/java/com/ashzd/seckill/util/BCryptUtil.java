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


    public static String encode(String password) {
        final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder.encode(password);
    }

    public static boolean match(String password, String encodedPassword) {
        final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder.matches(password, encodedPassword);
    }

}
