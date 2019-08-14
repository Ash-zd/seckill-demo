package com.ashzd.seckill.service;

import com.ashzd.seckill.dto.UserDTO;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @file: FileService
 * @author: Ash
 * @date: 2019/7/20 14:20
 * @description:
 * @since:
 **/
public interface FileService {

    String upload(MultipartFile file, UserDTO userDTO) throws IOException;

    void delete(String fileId, UserDTO userDTO);

    void download(String fileId, UserDTO userDTO, HttpServletRequest request, HttpServletResponse response) throws Exception;

}
