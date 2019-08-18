package com.ashzd.seckill.dto.req;

import java.io.Serializable;
import java.util.Objects;

/**
 * @file: SeckillReq
 * @author: Ash
 * @date: 2019/8/18 21:12
 * @description:
 * @since:
 */
public class SeckillReq implements Serializable {

    private Integer storeId;

    private Integer productId;

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SeckillReq that = (SeckillReq) o;
        return Objects.equals(storeId, that.storeId) &&
                Objects.equals(productId, that.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(storeId, productId);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SeckillReq{");
        sb.append("storeId=").append(storeId);
        sb.append(", productId=").append(productId);
        sb.append('}');
        return sb.toString();
    }
}
