package com.ashzd.seckill.manager.rabbitmq.dto;

import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/**
 * @file: MqMessage
 * @author: Ash
 * @date: 2019/8/18 14:31
 * @description:
 * @since:
 */
public class MqMessage implements Serializable {

    private static final long serialVersionUID = 8529560815368868849L;

    private String operation;

    private Map<String, Object> data;

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MqMessage mqMessage = (MqMessage) o;
        return Objects.equals(operation, mqMessage.operation) &&
                Objects.equals(data, mqMessage.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operation, data);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MqMessage{");
        sb.append("operation='").append(operation).append('\'');
        sb.append(", data=").append(data);
        sb.append('}');
        return sb.toString();
    }
}
