package com.ashzd.seckill.dto.req;

import java.util.Map;
import java.util.Objects;

/**
 * @file: PurchaseOrderReq
 * @author: Ash
 * @date: 2019/7/22 20:59
 * @description:
 * @since:
 **/
public class PurchaseOrderReq {

    private Integer storeId;

    private Map<Integer, Integer> products;

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Map<Integer, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<Integer, Integer> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PurchaseOrderReq{");
        sb.append("storeId=").append(storeId);
        sb.append(", products=").append(products);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PurchaseOrderReq orderReq = (PurchaseOrderReq) o;
        return Objects.equals(storeId, orderReq.storeId) &&
                Objects.equals(products, orderReq.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(storeId, products);
    }
}
