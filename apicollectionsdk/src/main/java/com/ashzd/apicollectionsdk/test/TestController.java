package com.ashzd.apicollectionsdk.test;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @file: TestController
 * @author: Ash
 * @date: 2019/12/9 19:43
 * @description:
 * @since:
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @ApiOperation(value = "test")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String testMethodA() {
        return "Test method A";
    }
}
