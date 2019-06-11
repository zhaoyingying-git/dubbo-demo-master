package com.test.dubboDemo.provider;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 〈${DESCRIPTION}〉
 *
 * @author zhaoyingying
 * @create 2019.4.30
 * @company 甜橙信息
 */
@Setter
@Getter
@ToString
public class TelecomBaseResBo implements Serializable {
    private String data;
    private String sign;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
