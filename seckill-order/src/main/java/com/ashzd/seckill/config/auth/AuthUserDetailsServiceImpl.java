package com.ashzd.seckill.config.auth;

import com.ashzd.seckill.entity.User;
import com.ashzd.seckill.service.AuthService;
import com.ashzd.seckill.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @file: AuthUserDetailsService
 * @author: Ash
 * @date: 2019/7/14 13:39
 * @description:
 * @since:
 **/
@Service
public class AuthUserDetailsServiceImpl implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(AuthUserDetailsServiceImpl.class);

    @Autowired
    private AuthService authService;
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String token) throws UsernameNotFoundException {
        String username = authService.getUsernameFromCacheByToken(token);
        User user = userService.getUserByUsername(username);
        if (Objects.isNull(user)) {
            logger.debug("No user found with user '{}'", username);
            throw new UsernameNotFoundException(String.format("No user found with user '%s'.", username));
        } else {
            return AuthUserConverter.toAuthUser(user);
        }
    }
}
