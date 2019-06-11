package com.test.dubboDemo.provider;

import com.alibaba.druid.util.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 〈${DESCRIPTION}〉
 *
 * @author xuezhongyang
 * @create 2018/12/10
 * @company 甜橙信息
 */

@Component
public class AH extends Parent {

    @Override
    public void queryPackageInfo() {
        System.out.println("ah");
    }
}
