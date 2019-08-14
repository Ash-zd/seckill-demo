package com.ashzd.seckill.config.auth;

import com.ashzd.seckill.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;

/**
 * @file: AuthUserConverter
 * @author: Ash
 * @date: 2019/7/14 13:54
 * @description:
 * @since:
 **/
public class AuthUserConverter {

    public static AuthUser toAuthUser(User user) {
        AuthUser authUser = new AuthUser();
        authUser.setId(user.getId());
        authUser.setUsername(user.getUsername());
        authUser.setPassword(user.getPassword());
        authUser.setEnabled(true);
        authUser.setAuthorities(mapToGrantedAuthorities(user.getIsUser()));
        return authUser;
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(boolean isUser) {
        List<GrantedAuthority> list = new ArrayList<>(2);
        list.add(new SimpleGrantedAuthority("ROLE_USER"));
        if (!isUser) {
            list.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }
        return list;
    }


}
