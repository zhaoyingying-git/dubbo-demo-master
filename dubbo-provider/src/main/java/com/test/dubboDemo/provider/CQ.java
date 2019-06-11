package com.test.dubboDemo.provider;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 〈${DESCRIPTION}〉
 *
 * @author xuezhongyang
 * @create 2019/02/25
 * @company 甜橙信息
 */



public class CQ extends Parent {
    private String viceCard;

    public String getViceCard() {
        return viceCard;
    }

    public void setViceCard(String viceCard) {
        this.viceCard = viceCard;
    }

    @Override
    public void queryPackageInfo() {
        System.out.println("cq");
    }


}
