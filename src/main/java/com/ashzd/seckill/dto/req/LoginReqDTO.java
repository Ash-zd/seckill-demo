package com.ashzd.seckill.dto.req;

import java.io.Serializable;
import java.util.Objects;

/**
 * @file: LoginReqDTO
 * @author: Ash
 * @date: 2019/7/14 14:40
 * @description:
 * @since:
 **/
public class LoginReqDTO implements Serializable {

    private static final long serialVersionUID = -104713132065703362L;

    private String username;

    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoginReqDTO that = (LoginReqDTO) o;
        return Objects.equals(username, that.username) &&
                Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("LoginReqDTO{");
        sb.append("username='").append(username).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
