package com.ashzd.seckill.dto.page;

import java.io.Serializable;
import java.util.Objects;

/**
 * @file: CommonPageReq
 * @author: Ash
 * @date: 2019/7/22 21:06
 * @description:
 * @since:
 **/
public class CommonPageReq implements Serializable {

    private Integer pageNo;

    private Integer pageSize;

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommonPageReq that = (CommonPageReq) o;
        return Objects.equals(pageNo, that.pageNo) &&
                Objects.equals(pageSize, that.pageSize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pageNo, pageSize);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CommonPageReq{");
        sb.append("pageNo=").append(pageNo);
        sb.append(", pageSize=").append(pageSize);
        sb.append('}');
        return sb.toString();
    }
}
