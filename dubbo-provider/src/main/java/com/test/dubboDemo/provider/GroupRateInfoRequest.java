package com.test.dubboDemo.provider;

import lombok.*;

/**
 * 〈${DESCRIPTION}〉
 *
 * @author zhaoyingying
 * @create 2019.04.30
 * @company 甜橙信息
 */
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class GroupRateInfoRequest {

        private Integer conNum;

        private Integer rate;

    public Integer getConNum() {
        return conNum;
    }

    public void setConNum(Integer conNum) {
        this.conNum = conNum;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }
}

