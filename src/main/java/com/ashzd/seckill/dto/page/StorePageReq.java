package com.ashzd.seckill.dto.page;

import java.util.Objects;

/**
 * @file: StorePageReq
 * @author: Ash
 * @date: 2019/7/22 20:13
 * @description:
 * @since:
 **/
public class StorePageReq extends CommonPageReq {

    private static final long serialVersionUID = -3622202459482849261L;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("StorePageReq{");
        sb.append("name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        StorePageReq that = (StorePageReq) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name);
    }
}
