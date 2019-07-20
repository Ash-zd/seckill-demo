package com.ashzd.seckill.controller.common;

import com.ashzd.seckill.dto.UserDTO;
import com.ashzd.seckill.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @file: BaseController
 * @author: Ash
 * @date: 2019/7/13 16:11
 * @description:
 * @since:
 **/
public class BaseController {

    @Autowired
    private UserService userService;

    protected SecurityContext getCurrentSecurityContext(HttpServletRequest request) {
        return SecurityContextHolder.getContext();
    }

    protected String getCurrentUsername(HttpServletRequest request) {
        SecurityContext securityContext = getCurrentSecurityContext(request);
        return securityContext.getAuthentication().getName();
    }

    protected UserDetails getCurrentUserDetails(HttpServletRequest request) {
        SecurityContext securityContext = getCurrentSecurityContext(request);
        return (UserDetails) securityContext.getAuthentication().getDetails();
    }

    protected List<GrantedAuthority> getCurrentUserAuthorities(HttpServletRequest request) {
        SecurityContext securityContextImpl = getCurrentSecurityContext(request);
        return (List<GrantedAuthority>) securityContextImpl.getAuthentication().getAuthorities();
    }

    protected UserDTO getCurrentUserDTO(HttpServletRequest request) {
        String username = getCurrentUsername(request);
        return userService.getUserDTOByUsername(username);
    }

}
