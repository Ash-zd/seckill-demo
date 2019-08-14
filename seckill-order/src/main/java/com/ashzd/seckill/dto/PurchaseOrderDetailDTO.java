package com.ashzd.seckill.dto;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * @file: PurchaseOrderDetailDTO
 * @author: Ash
 * @date: 2019/7/22 20:59
 * @description:
 * @since:
 **/
public class PurchaseOrderDetailDTO {

    private String orderIndexCode;

    private Integer productId;

    private String productName;

    private String productDescription;

    private Integer productQuantity;

    private BigDecimal productUnitPrice;

    public PurchaseOrderDetailDTO() {
    }

    public PurchaseOrderDetailDTO(String orderIndexCode, Integer productId, Integer productQuantity) {
        this.orderIndexCode = orderIndexCode;
        this.productId = productId;
        this.productQuantity = productQuantity;
    }

    public String getOrderIndexCode() {
        return orderIndexCode;
    }

    public void setOrderIndexCode(String orderIndexCode) {
        this.orderIndexCode = orderIndexCode;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Integer getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }

    public BigDecimal getProductUnitPrice() {
        return productUnitPrice;
    }

    public void setProductUnitPrice(BigDecimal productUnitPrice) {
        this.productUnitPrice = productUnitPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PurchaseOrderDetailDTO that = (PurchaseOrderDetailDTO) o;
        return Objects.equals(orderIndexCode, that.orderIndexCode) &&
                Objects.equals(productId, that.productId) &&
                Objects.equals(productName, that.productName) &&
                Objects.equals(productDescription, that.productDescription) &&
                Objects.equals(productQuantity, that.productQuantity) &&
                Objects.equals(productUnitPrice, that.productUnitPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderIndexCode, productId, productName, productDescription, productQuantity, productUnitPrice);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PurchaseOrderDetailDTO{");
        sb.append("orderIndexCode='").append(orderIndexCode).append('\'');
        sb.append(", productId=").append(productId);
        sb.append(", productName='").append(productName).append('\'');
        sb.append(", productDescription='").append(productDescription).append('\'');
        sb.append(", productQuantity=").append(productQuantity);
        sb.append(", productUnitPrice=").append(productUnitPrice);
        sb.append('}');
        return sb.toString();
    }
}
