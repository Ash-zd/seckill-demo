package com.ashzd.seckill.dto.common;

import java.util.Objects;

/**
 * @file: ResponseData
 * @author: Ash
 * @date: 2019/7/13 21:01
 * @description:
 * @since:
 **/
public class ResponseData extends CommonResponse {

    private static final long serialVersionUID = 4851115115152899314L;

    private Object data;

    public ResponseData() {
    }

    public static ResponseData success() {
        ResponseData responseData = new ResponseData();
        responseData.setMessage("success");
        responseData.setCode("200");
        responseData.setData(null);
        return responseData;
    }

    public static ResponseData success(Object data) {
        ResponseData responseData = new ResponseData();
        responseData.setMessage("success");
        responseData.setCode("200");
        responseData.setData(data);
        return responseData;
    }

    public static ResponseData success(String message, Object data) {
        ResponseData responseData = new ResponseData();
        responseData.setMessage(message);
        responseData.setCode("200");
        responseData.setData(data);
        return responseData;
    }

    public static ResponseData failure(Object data) {
        ResponseData responseData = new ResponseData();
        responseData.setMessage("failed");
        responseData.setCode("400");
        responseData.setData(data);
        return responseData;
    }

    public static ResponseData failure() {
        ResponseData responseData = new ResponseData();
        responseData.setMessage("failed");
        responseData.setCode("400");
        responseData.setData(null);
        return responseData;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResponseData that = (ResponseData) o;
        return Objects.equals(message, that.message) &&
                Objects.equals(code, that.code) &&
                Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message, code, data);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ResponseData{");
        sb.append("message='").append(message).append('\'');
        sb.append(", code='").append(code).append('\'');
        sb.append(", data=").append(data);
        sb.append('}');
        return sb.toString();
    }
}
