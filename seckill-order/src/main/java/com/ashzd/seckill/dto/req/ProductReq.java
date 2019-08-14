package com.ashzd.seckill.dto.req;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * @file: ProductReq
 * @author: Ash
 * @date: 2019/7/22 20:29
 * @description:
 * @since:
 **/
public class ProductReq {

    private Integer storeId;

    private String name;

    private String description;

    private BigDecimal price;

    private Integer quantity;

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductReq that = (ProductReq) o;
        return Objects.equals(storeId, that.storeId) &&
                Objects.equals(name, that.name) &&
                Objects.equals(description, that.description) &&
                Objects.equals(price, that.price) &&
                Objects.equals(quantity, that.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(storeId, name, description, price, quantity);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ProductReq{");
        sb.append("storeId=").append(storeId);
        sb.append(", name='").append(name).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", price=").append(price);
        sb.append(", quantity=").append(quantity);
        sb.append('}');
        return sb.toString();
    }
}
