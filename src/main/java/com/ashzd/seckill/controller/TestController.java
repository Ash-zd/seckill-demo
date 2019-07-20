package com.ashzd.seckill.controller;

import com.ashzd.seckill.controller.common.BaseController;
import com.ashzd.seckill.dto.common.ResponseData;
import com.ashzd.seckill.service.FileService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @file: TestController
 * @author: Ash
 * @date: 2019/7/13 16:11
 * @description:
 * @since:
 **/
@RestController
@RequestMapping("/test")
public class TestController extends BaseController {

    @Autowired
    private FileService fileService;

    @ApiOperation(value = "上传文件")
    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public ResponseData uploadFile(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
        fileService.upload(file, getCurrentUserDTO(request));
        return ResponseData.success();
    }

    @ApiOperation(value = "删除文件")
    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value = "/deleteFile", method = RequestMethod.POST)
    public ResponseData deleteFile(@RequestParam("fileId") String fileId, HttpServletRequest request) throws IOException {
        fileService.delete(fileId, getCurrentUserDTO(request));
        return ResponseData.success();
    }

    @ApiOperation(value = "下载文件")
    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value = "/downloadFile", method = RequestMethod.POST)
    public void downloadFile(@RequestParam("fileId") String fileId, HttpServletRequest request, HttpServletResponse response) throws Exception {
        fileService.download(fileId, getCurrentUserDTO(request), request, response);
    }

}
