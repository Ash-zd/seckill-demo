package com.ashzd.seckill.dto.common;

import java.io.Serializable;
import java.util.Objects;

/**
 * @file: CommonResponse
 * @author: Ash
 * @date: 2019/7/16 21:24
 * @description:
 * @since:
 **/
public class CommonResponse implements Serializable {

    private static final long serialVersionUID = 6773024080459711435L;
    protected String code;

    protected String message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommonResponse that = (CommonResponse) o;
        return Objects.equals(code, that.code) &&
                Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, message);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CommonResponse{");
        sb.append("code='").append(code).append('\'');
        sb.append(", message='").append(message).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
