package com.ashzd.seckill.util.converter;

import com.ashzd.seckill.dto.FileDTO;
import com.ashzd.seckill.entity.File;

import java.util.Date;

/**
 * @file: FileConverter
 * @author: Ash
 * @date: 2019/7/20 14:41
 * @description:
 * @since:
 **/
public class FileConverter {

    public static File toFile(FileDTO fileDTO) {
        File file = new File();
        file.setObjectId(fileDTO.getObjectId());
        file.setUserId(fileDTO.getUserId());
        file.setFilename(fileDTO.getFilename());
        file.setContentType(fileDTO.getContentType());
        file.setCreatedAt(new Date());
        file.setUpdatedAt(new Date());
        return file;
    }

    public static FileDTO toFileDTO(File file) {
        FileDTO fileDTO = new FileDTO();
        fileDTO.setObjectId(file.getObjectId());
        fileDTO.setUserId(file.getUserId());
        fileDTO.setFilename(file.getFilename());
        fileDTO.setContentType(file.getContentType());
        return fileDTO;
    }

}
