package com.ashzd.seckill.dto;

import com.ashzd.seckill.dto.req.OrderProductDTO;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * @file: OrderDTO
 * @author: Ash
 * @date: 2019/7/22 20:59
 * @description:
 * @since:
 **/
public class OrderDTO {

    private Integer id;

    private String orderIndexCode;

    private OrderProductDTO detail;

    private BigDecimal price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderIndexCode() {
        return orderIndexCode;
    }

    public void setOrderIndexCode(String orderIndexCode) {
        this.orderIndexCode = orderIndexCode;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public OrderProductDTO getDetail() {
        return detail;
    }

    public void setDetail(OrderProductDTO detail) {
        this.detail = detail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDTO orderDTO = (OrderDTO) o;
        return Objects.equals(id, orderDTO.id) &&
                Objects.equals(orderIndexCode, orderDTO.orderIndexCode) &&
                Objects.equals(detail, orderDTO.detail) &&
                Objects.equals(price, orderDTO.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderIndexCode, detail, price);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OrderDTO{");
        sb.append("id=").append(id);
        sb.append(", orderIndexCode='").append(orderIndexCode).append('\'');
        sb.append(", detail=").append(detail);
        sb.append(", price=").append(price);
        sb.append('}');
        return sb.toString();
    }
}
