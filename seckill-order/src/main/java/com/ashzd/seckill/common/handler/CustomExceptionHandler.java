package com.ashzd.seckill.common.handler;

import com.ashzd.seckill.common.exception.CustomException;
import com.ashzd.seckill.dto.common.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;

/**
 * @file: CustomExceptionHandler
 * @author: Ash
 * @date: 2019/7/16 21:21
 * @description:
 * @since:
 **/
@RestControllerAdvice
public class CustomExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(CustomExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    public ErrorResponse commonExceptionHandler(Exception e, HttpServletResponse response) {
        logger.debug("exception occurred! message is '{}'", e.getMessage(), e);
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setCode("400");
        errorResponse.setMessage("系统异常");
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        return errorResponse;
    }

    @ExceptionHandler(value = CustomException.class)
    public ErrorResponse customExceptionHandler(CustomException e, HttpServletResponse response) {
        logger.debug("exception occurred! message is '{}'", e.getMessage(), e);
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setCode("400");
        errorResponse.setMessage(e.getMessage());
        response.setStatus(HttpServletResponse.SC_OK);
        return errorResponse;
    }


    @ExceptionHandler(value = DataIntegrityViolationException.class)
    public ErrorResponse sqlExceptionHandler(DataIntegrityViolationException e, HttpServletResponse response) {
        logger.debug("sql exception occurred! message is '{}'", e.getMessage(), e);
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setCode("400");
        errorResponse.setMessage("数据库执行错误");
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        return errorResponse;
    }

    @ExceptionHandler(value = IllegalArgumentException.class)
    public ErrorResponse illegalArgumentExceptionHandler(IllegalArgumentException e) {
        logger.debug("IllegalArgumentException occurred! message is '{}'", e.getMessage(), e);
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setCode("400");
        errorResponse.setMessage(e.getMessage());
        return errorResponse;
    }

    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public ErrorResponse httpMessageNotReadableExceptionHandler(HttpMessageNotReadableException e) {
        logger.debug("HttpMessageNotReadableException occurred! message is '{}'", e.getMessage(), e);
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setCode("400");
        errorResponse.setMessage(e.getMessage());
        return errorResponse;
    }

}
