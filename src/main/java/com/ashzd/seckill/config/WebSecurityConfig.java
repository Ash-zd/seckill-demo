package com.ashzd.seckill.config;

import com.ashzd.seckill.common.constant.AuthConstant;
import com.ashzd.seckill.common.constant.ProfileConstant;
import com.ashzd.seckill.config.auth.AuthAuthenticationEntryPoint;
import com.ashzd.seckill.config.auth.AuthTokenFilter;
import com.ashzd.seckill.config.auth.AuthUserDetailsServiceImpl;
import com.ashzd.seckill.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @file: WebSecurityConfig
 * @author: Ash
 * @date: 2019/7/14 13:12
 * @description:
 * @since:
 **/
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${spring.profiles.active}")
    private String activeEnvironment;

    @Autowired
    private AuthUserDetailsServiceImpl authUserDetailsService;
    @Autowired
    private AuthAuthenticationEntryPoint authAuthenticationEntryPoint;
    @Autowired
    private AuthTokenFilter authTokenFilter;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(authUserDetailsService)
                .passwordEncoder(passwordEncoderBean());
    }

    @Bean
    public PasswordEncoder passwordEncoderBean() {
        return new BCryptPasswordEncoder();
    }

    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf().disable()
                .exceptionHandling().authenticationEntryPoint(authAuthenticationEntryPoint).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests()
                .antMatchers("/v1/api/auth/**").permitAll()
                .antMatchers("/v1/api/user").permitAll()
                .antMatchers("/test/**").permitAll()
                .antMatchers("/actuator/**").hasRole("ADMIN")
                .antMatchers("/error").permitAll()
                .anyRequest().authenticated();

        httpSecurity.addFilterBefore(authTokenFilter, UsernamePasswordAuthenticationFilter.class);

        httpSecurity
                .headers()
                .frameOptions().sameOrigin()
                .cacheControl();
    }

    @Override
    public void configure(WebSecurity web) {
        if (!StringUtil.equals(ProfileConstant.PRO, activeEnvironment)) {
            web
                    .ignoring()
                    .antMatchers(
                            HttpMethod.POST,
                            AuthConstant.AUTH_PATH
                    )
                    .and()
                    .ignoring()
                    .antMatchers(
                            HttpMethod.GET,
                            "/",
                            "/*.html",
                            "/favicon.ico",
                            "/**/*.html",
                            "/**/*.css",
                            "/**/*.js",
                            "/**/*.woff2",
                            "/**/*.woff"
                    )
                    .and()
                    .ignoring()
                    .antMatchers(
                            "/swagger-ui.html",
                            // swagger api json
                            "/v2/api-docs",
                            // 用来获取支持的动作
                            "/swagger-resources/configuration/ui",
                            // 用来获取api-docs的URI
                            "/swagger-resources",
                            // 安全选项
                            "/swagger-resources/configuration/security",
                            "/swagger-resources/**",
                            "/webjars/springfox-swagger-ui/**"
                    );
        }
    }


}
