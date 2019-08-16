//package com.ashzd.seckill.common.aop;
//
//import org.aspectj.lang.annotation.After;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//
//import java.util.Date;
//
///**
// * @file: LogAOP
// * @author: Ash
// * @date: 2019/8/15 0:03
// * @description:
// * @since:
// */
//@Aspect
//@Component
//public class LogAOP {
//
//    private static final Logger logger = LoggerFactory.getLogger(LogAOP.class);
//
//    @Pointcut("execution(* com.ashzd.seckill.controller.*(..))")
//    public void webLog() {
//    }
//
//    @Before(value = "webLog()")
//    public void before() {
//        logger.info("request start at '{}'", new Date());
//    }
//
//    @After(value = "webLog()")
//    public void after() {
//        logger.info("request end at '{}'", new Date());
//    }
//
//
//
//}
