package com.ashzd.seckill.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * @file: UserDTO
 * @author: Ash
 * @date: 2019/7/13 21:34
 * @description:
 * @since:
 **/
public class UserDTO implements Serializable {

    private static final long serialVersionUID = -3318797561450888515L;

    private Integer userId;

    private String username;

    private String email;

    private Boolean isUser;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getUser() {
        return isUser;
    }

    public void setUser(Boolean user) {
        isUser = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO userDTO = (UserDTO) o;
        return Objects.equals(userId, userDTO.userId) &&
                Objects.equals(username, userDTO.username) &&
                Objects.equals(email, userDTO.email) &&
                Objects.equals(isUser, userDTO.isUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, username, email, isUser);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserDTO{");
        sb.append("userId=").append(userId);
        sb.append(", username='").append(username).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", isUser=").append(isUser);
        sb.append('}');
        return sb.toString();
    }
}
