package com.ashzd.seckill.common.interceptor;

import com.alibaba.fastjson.JSON;
import com.ashzd.seckill.dto.common.ResponseData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @file: AbstractInterceptor
 * @author: Ash
 * @date: 2019/8/27 19:19
 * @description:
 * @since:
 */
public abstract class AbstractInterceptor extends HandlerInterceptorAdapter {
    private static final Logger logger = LoggerFactory.getLogger(AbstractInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        ResponseData result = null;
        result = preFilter(request);
        if ("200".equals(result.getCode())) {
            return true;
        } else {
            handleResponse(result, response);
            return false;
        }
    }

    protected abstract ResponseData preFilter(HttpServletRequest request);

    private void handleResponse(ResponseData responseData, HttpServletResponse response) {
        try (PrintWriter writer = response.getWriter()) {
            writer.write(JSON.toJSONString(responseData));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
