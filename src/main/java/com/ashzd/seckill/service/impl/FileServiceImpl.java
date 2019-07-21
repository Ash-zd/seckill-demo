package com.ashzd.seckill.service.impl;

import com.ashzd.seckill.dto.FileDTO;
import com.ashzd.seckill.dto.UserDTO;
import com.ashzd.seckill.entity.File;
import com.ashzd.seckill.entity.FileExample;
import com.ashzd.seckill.mapper.FileMapper;
import com.ashzd.seckill.service.FileService;
import com.ashzd.seckill.util.StringUtil;
import com.ashzd.seckill.util.converter.FileConverter;
import com.mongodb.client.gridfs.model.GridFSFile;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @file: FileServiceImpl
 * @author: Ash
 * @date: 2019/7/20 14:20
 * @description:
 * @since:
 **/
@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private GridFsTemplate gridFsTemplate;
    @Autowired
    private FileMapper fileMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String upload(MultipartFile file, UserDTO userDTO) throws IOException {
        // 参数校验
        Assert.notNull(file, "文件为空");
        // 获得提交的文件名
        String fileName = file.getOriginalFilename();
        // 获得文件输入流
        InputStream ins = file.getInputStream();
        // 获得文件类型
        String contentType = file.getContentType();
        // 将文件存储到mongodb中,mongodb 将会返回这个文件的具体信息
        ObjectId objectId = gridFsTemplate.store(ins, fileName, contentType);
        //将文件信息保存到关系型数据库中进行维护
        FileDTO fileDTO = new FileDTO();
        fileDTO.setObjectId(objectId.toString());
        fileDTO.setUserId(userDTO.getUserId());
        fileDTO.setFilename(fileName);
        fileDTO.setContentType(contentType);
        File dbFile = FileConverter.toFile(fileDTO);
        fileMapper.insertSelective(dbFile);
        return objectId.toString();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(String fileId, UserDTO userDTO) {
        // 参数校验
        Assert.isTrue(StringUtil.isNotBlank(fileId), "文件编号为空");
        File file = this.getFileByFileIdAndUserId(fileId, userDTO.getUserId());
        // 删除mongodb里的文件
        Query query = Query.query(Criteria.where("_id").is(fileId));
        GridFSFile gridFSFile = gridFsTemplate.findOne(query);
        Assert.notNull(gridFSFile, "文件不存在");
        gridFsTemplate.delete(query);
        // 删除mysql的记录
        fileMapper.deleteByPrimaryKey(file.getId());
    }

    @Override
    public void download(String fileId, UserDTO userDTO, HttpServletRequest request, HttpServletResponse response) throws Exception {
        File file = this.getFileByFileIdAndUserId(fileId, userDTO.getUserId());
        Assert.notNull(file, "文件不存在");
        Query query = Query.query(Criteria.where("_id").is(fileId));
        GridFSFile gridFSFile = gridFsTemplate.findOne(query);
        Assert.notNull(gridFSFile, "文件不存在");
        String filename = gridFSFile.getFilename().replace(",", "");
        // 处理中文文件名乱码
        if (request.getHeader("User-Agent").toUpperCase().contains("MSIE") ||
                request.getHeader("User-Agent").toUpperCase().contains("TRIDENT")
                || request.getHeader("User-Agent").toUpperCase().contains("EDGE")) {
            filename = java.net.URLEncoder.encode(filename, StandardCharsets.UTF_8);
        } else {
            // 非IE浏览器的处理：
            filename = new String(filename.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1);
        }
        // 通知浏览器进行文件下载
        GridFsResource gridFsResource = gridFsTemplate.getResource(gridFSFile);
        response.setHeader("Content-Disposition", "attachment;filename=\"" + filename + "\"");
        IOUtils.copy(gridFsResource.getInputStream(), response.getOutputStream());
        response.getOutputStream().flush();
    }

    private File getFileByFileIdAndUserId(String fileId, Integer userId) {
        FileExample example = new FileExample();
        example.createCriteria().andObjectIdEqualTo(fileId).andUserIdEqualTo(userId);
        List<File> files = fileMapper.selectByExample(example);
        Assert.notEmpty(files, "文件不存在");
        return files.get(0);
    }
}
