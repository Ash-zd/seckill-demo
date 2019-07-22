package com.ashzd.seckill.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * @file: StoreDTO
 * @author: Ash
 * @date: 2019/7/22 19:41
 * @description:
 * @since:
 **/
public class StoreDTO implements Serializable {

    private Integer id;
    private String name;
    private String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StoreDTO storeDTO = (StoreDTO) o;
        return Objects.equals(id, storeDTO.id) &&
                Objects.equals(name, storeDTO.name) &&
                Objects.equals(description, storeDTO.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description);
    }

    @Override
    public String
    toString() {
        final StringBuilder sb = new StringBuilder("StoreDTO{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
}
