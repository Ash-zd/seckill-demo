package com.ashzd.seckill.common.handler;

import com.ashzd.seckill.dto.common.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

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
    public ErrorResponse commonExceptionHandler(Exception e) {
        logger.debug("exception occurred! message is '{}'", e.getMessage(), e);
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setCode("400");
        errorResponse.setMessage(e.getMessage());
        return errorResponse;
    }

}
