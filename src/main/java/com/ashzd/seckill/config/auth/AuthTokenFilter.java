package com.ashzd.seckill.config.auth;

import com.ashzd.seckill.common.constant.AuthConstant;
import com.ashzd.seckill.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @file: AuthTokenFilter
 * @author: Ash
 * @date: 2019/7/14 14:18
 * @description:
 * @since:
 **/
@Component
public class AuthTokenFilter extends OncePerRequestFilter {

    private static final Logger logger = LoggerFactory.getLogger(AuthTokenFilter.class);

    @Autowired
    private AuthUserDetailsServiceImpl authUserDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        logger.debug("processing authentication for '{}'", httpServletRequest.getRequestURL());
        final String requestHeader = httpServletRequest.getHeader(AuthConstant.AUTHORIZATION_HEADER);
        String authToken = null;
        if (requestHeader != null && requestHeader.startsWith(AuthConstant.BEARER_HEADER)) {
            authToken = requestHeader.substring(7);
        } else {
            logger.warn("couldn't find bearer string, will ignore the header");
        }
        logger.debug("checking authentication for token '{}'", authToken);
        if (StringUtil.isNotBlank(authToken) && SecurityContextHolder.getContext().getAuthentication() == null) {
            logger.debug("security context was null, so authorizing user");

            UserDetails userDetails;
            try {
                userDetails = authUserDetailsService.loadUserByUsername(authToken);
            } catch (UsernameNotFoundException e) {
                httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, e.getMessage());
                return;
            }
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }

        filterChain.doFilter(httpServletRequest, httpServletResponse);

    }
}
