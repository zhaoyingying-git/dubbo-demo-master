package com.test.dubboDemo.provider;


import com.alibaba.fastjson.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:spring.xml"})
public class Test1 {
    @Autowired
    private ICacheService iCacheService;
    @Test
    public void tests(){
        GroupCreditRequest groupCreditRequest = new GroupCreditRequest();
        groupCreditRequest.setCertNum("1111");
        groupCreditRequest.setCertType("1111");
        groupCreditRequest.setCreditLine(800);
        groupCreditRequest.setCreditType("1111");
        groupCreditRequest.setCustName("11111");
        groupCreditRequest.setDigitalCode((long) 123);
        groupCreditRequest.setEffDate(new SimpleDateFormat("yyyy-MM-dd'T'HH：mm：ss.SSS Z").format(new Date()));
        groupCreditRequest.setExpDate(new SimpleDateFormat("yyyy-MM-dd'T'HH：mm：ss.SSS Z").format(new Date()));
        List<GroupRateInfoRequest> list = new ArrayList<>();
//        for (RateInfoRequestBo rateInfoRequestBo: creditInfoBo.getRateInfoRequestBos()){
            GroupRateInfoRequest groupRateInfoRequest = new GroupRateInfoRequest();
            groupRateInfoRequest.setConNum(234);
            groupRateInfoRequest.setRate(56);
            list.add(groupRateInfoRequest);
//        }
        groupCreditRequest.setGroupRateInfoRequests(list);

        String date = RSAUtils.encrypt(GsonJsonUtil.toJson(groupCreditRequest),"MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCsLOKmGlbZ9IOx2C604w0xgoqWQQVHtgHQ+KfiL1zyRsv5VzafLLuDRsFXTRtECGs9Mmg/t1YmVIY04tumeBy8cLQ3Q0QrWo604A6U1Jlsfl+91mOK0KTY8U6nmup/KaBtRveeVH4SRFTaul/O3G16NsAL6jlAZADlhd/tmLxcSQIDAQAB"
        );
        String sign = RSAUtils.sign(GsonJsonUtil.toJson(groupCreditRequest),"MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAJm6HdtoPuz7HSTn8hwyse7+b5FS6Vdaq/Sc5Bt7QL+SbtxnTG/rk7H/ZCYQE3z7YL6/t6OrS8fG6cJhtyf0fPP225X2XvVYRU+NK0dytfs3QJ8U8KKfbmQJyUdjerEPMvv71D7RtatFpHY6YMczM5/5JvS3/pygUVQP8sdeZhkzAgMBAAECgYB/JDJrc8WPhITvMDLK5ZbKXn9xxwwcZm6Pym7S19aOWxL7kSfj7QfjkKGI5YToupOiT7gXUqZDXZ2aWez8y7XHUtinZLbnThx/WxURdbrOubwlAauVwy90EztwtXGa0+q9Ln7wiPdW7yxHp+0OxXXp9wqZNhLhldX3+Dw+QhdreQJBAP12jEzCeQj0/8TW7XEuxvBS/nWGvv/0Tk0o07cGvngEFZ7PsdFfBDQJ+R37vtA8KsyYiHu7xz+9GFX6cUi2sg0CQQCbRAN0bdYo6rHEgHsI5kL3u9uaruFnfCD0lQ9u/ItmeiL1SUjEz4E9bVLYDLgVfM8oFfKbG43VthCiCaX9x2g/AkEA92Eo9hIox5E3wQp0nK8nA5A9Qr/M00vC0JQ0bsJqTADQiTv1NYAjPhctyRHX3q2aqC2HqBxSD+ejROc2gd2uUQJAXPb0OpopSIZ9ufJTuJhmMH7ClnNvcs7XzJoTi5iavtkSZVtjvrOf5m+20rWK4xK/1niNsmFlIzjH7L1qLfFfcQJAPboAgbc5U54fG+sYNP78T5D4exn+21zA1XUqe/vI216nABAp0pG+uk3qDWng35oyyvyRXArF9Ydc3rwTofiw/Q=="
        );
        System.out.println("date="+date+"\n"+"sign="+sign);
    }

}


