package com.ashzd.seckill.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * @file: FileDTO
 * @author: Ash
 * @date: 2019/7/20 14:42
 * @description:
 * @since:
 **/
public class FileDTO implements Serializable {

    private static final long serialVersionUID = -5579953179538497539L;

    private String objectId;

    private Integer userId;

    private String filename;

    private String contentType;

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FileDTO fileDTO = (FileDTO) o;
        return Objects.equals(objectId, fileDTO.objectId) &&
                Objects.equals(userId, fileDTO.userId) &&
                Objects.equals(filename, fileDTO.filename) &&
                Objects.equals(contentType, fileDTO.contentType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(objectId, userId, filename, contentType);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FileDTO{");
        sb.append("objectId='").append(objectId).append('\'');
        sb.append(", userId=").append(userId);
        sb.append(", filename='").append(filename).append('\'');
        sb.append(", contentType='").append(contentType).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
