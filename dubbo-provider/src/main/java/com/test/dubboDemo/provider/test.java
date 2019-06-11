package com.test.dubboDemo.provider;


import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class test {
    public static  void main(String[] arg) throws ParseException, DocumentException {
String a ="{\n" +
        "    \"resultCode\": \"0\",\n" +
        "    \"resultMsg\": \"成功\",\n" +
        "    \"prodInstId\": \"\",\n" +
        "    \"prodFinishDate\": \"2018/11/30\",\n" +
        "    \"userName\": \"蔡**\",\n" +
        "    \"userIdCode\": \"\",\n" +
        "    \"userBirth\": \"\",\n" +
        "    \"userSex\": \"\",\n" +
        "    \"userAddress\": \"\",\n" +
        "    \"userGrade\": \"\",\n" +
        "    \"netAge\": \"\",\n" +
        "    \"imei\": \"\",\n" +
        "    \"simCode\": \"\",\n" +
        "    \"viceCardFlag\": \"0\",\n" +
        "    \"disassembleFlag\": \"0\",\n" +
        "    \"hallNo\": \"1000000079357\",\n" +
        "    \"hallAddress\": \"双峰县_双峰_公众_六里牌\"\n" +
        "    \n" +
        "}";

        //1、使用JSONObject
        JSONObject jsonObject=JSONObject.fromObject(a);
        HNPackageBo hnPackageBo=(HNPackageBo)JSONObject.toBean(jsonObject,
                HNPackageBo.class);
           System.out.println(JSONObject.fromObject(getCrmCommonBOHNPackageBO(hnPackageBo,new CrmQueryCommonBo())).toString());
    }

    public static Date date(String source) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date;
        try {
            date = sdf.parse(source);
        } catch (Exception e) {
            date = null;
        }
        return date;
    }

    public static CrmQueryCommonBo getCrmCommonBOHNPackageBO(HNPackageBo hnPackageBo, CrmQueryCommonBo crmQueryCommonBo) throws ParseException {
        crmQueryCommonBo.setUserIdCode(org.apache.commons.lang.StringUtils.isBlank(hnPackageBo.getUserIdCode())? null:hnPackageBo.getUserIdCode());
        crmQueryCommonBo.setUserSex(org.apache.commons.lang.StringUtils.isBlank(hnPackageBo.getUserSex())? null:hnPackageBo.getUserSex());
        crmQueryCommonBo.setUserBirth(org.apache.commons.lang.StringUtils.isBlank(hnPackageBo.getUserBirth()) ? null : new SimpleDateFormat("yyyy-MM-dd").parse(hnPackageBo.getUserBirth()));
        crmQueryCommonBo.setContactAddress(org.apache.commons.lang.StringUtils.isBlank(hnPackageBo.getUserAddress())? null:hnPackageBo.getUserAddress());
        crmQueryCommonBo.setUserGrade(org.apache.commons.lang.StringUtils.isBlank(hnPackageBo.getUserGrade())? null:hnPackageBo.getUserGrade());
        crmQueryCommonBo.setNetAge(org.apache.commons.lang.StringUtils.isBlank(hnPackageBo.getNetAge())? null:hnPackageBo.getNetAge());
        crmQueryCommonBo.setIMEI(org.apache.commons.lang.StringUtils.isBlank(hnPackageBo.getImei())? null:hnPackageBo.getImei());
        crmQueryCommonBo.setMobileHCode(org.apache.commons.lang.StringUtils.isBlank(hnPackageBo.getSimCode())? null:hnPackageBo.getSimCode());
        if (Objects.equals("1", hnPackageBo.getViceCardFlag())) {
            crmQueryCommonBo.setViceCard(true);
        } else if (Objects.equals("0", hnPackageBo.getViceCardFlag())) {
            crmQueryCommonBo.setViceCard(false);
        }
        if (Objects.equals("1", hnPackageBo.getDisassembleFlag())) {
            crmQueryCommonBo.setDisassembleFlag(true);
        } else if (Objects.equals("0", hnPackageBo.getDisassembleFlag())) {
            crmQueryCommonBo.setDisassembleFlag(false);
        }
        crmQueryCommonBo.setHallNo(org.apache.commons.lang.StringUtils.isBlank(hnPackageBo.getHallNo())? null:hnPackageBo.getHallNo());
        crmQueryCommonBo.setHallAddress(org.apache.commons.lang.StringUtils.isBlank(hnPackageBo.getHallAddress())? null:hnPackageBo.getHallAddress());
        crmQueryCommonBo.setProdInstId(org.apache.commons.lang.StringUtils.isBlank(hnPackageBo.getProdInstId())? null : Long.valueOf(hnPackageBo.getProdInstId()));
        crmQueryCommonBo.setFinishDate(org.apache.commons.lang.StringUtils.isBlank(hnPackageBo.getProdFinishDate()) ? null : new SimpleDateFormat("yyyy/MM/dd").parse(hnPackageBo.getProdFinishDate()));
//        crmQueryCommonBo.setProdOfferInstBaseBOS(getCrmProdOfferBOByHNPackageBo(list));

        return crmQueryCommonBo;
    }

//    public static List<ProdOfferInstBaseBO> getCrmProdOfferBOByHNPackageBo(List<OferInsts> oferInstsList) {
//        List<ProdOfferInstBaseBO> prodOfferInstBaseBOS = new ArrayList<>();
//        for (OferInsts oferInsts : oferInstsList) {
//            ProdOfferInstBaseBO prodOfferInstBaseBO = new ProdOfferInstBaseBO();
//            prodOfferInstBaseBO.setOfferInstId(org.apache.commons.lang.StringUtils.isBlank(oferInsts.getOfferInstId())? null:oferInsts.getOfferInstId());
//            prodOfferInstBaseBO.setProdOfferId(org.apache.commons.lang.StringUtils.isBlank(oferInsts.getOfferId())? null:oferInsts.getOfferId());
//            prodOfferInstBaseBO.setProdOfferName(org.apache.commons.lang.StringUtils.isBlank(oferInsts.getOfferName())? null:oferInsts.getOfferName());
//            try {
//                prodOfferInstBaseBO.setEffDate(org.apache.commons.lang.StringUtils.isBlank(oferInsts.getEffDate()) ? null :new SimpleDateFormat("yyyy/MM/dd").parse(oferInsts.getEffDate()));
//                prodOfferInstBaseBO.setExpDate(org.apache.commons.lang.StringUtils.isBlank(oferInsts.getExpDate()) ? null :new SimpleDateFormat("yyyy/MM/dd").parse(oferInsts.getExpDate()));
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
//            if (Objects.equals("1000", oferInsts.getStatusCd())) {
//                prodOfferInstBaseBO.setStatusCd("ENABLE");
//            } else if (Objects.equals("1101", oferInsts.getStatusCd())) {
//                prodOfferInstBaseBO.setStatusCd("DISABLE");
//            }
//            prodOfferInstBaseBO.setPackageOrderNo(org.apache.commons.lang.StringUtils.isBlank(oferInsts.getCustOrderNbr())? null:oferInsts.getCustOrderNbr());
//            prodOfferInstBaseBO.setProdOfferAmt(org.apache.commons.lang.StringUtils.isBlank(oferInsts.getProdOfferAmt()) ? null:oferInsts.getProdOfferAmt());
//            prodOfferInstBaseBO.setProdMonthRetAmt(org.apache.commons.lang.StringUtils.isBlank(oferInsts.getProdMonthRetAmt())? null: Long.valueOf(oferInsts.getProdMonthRetAmt()));
//            prodOfferInstBaseBO.setSubsidyAmt(org.apache.commons.lang.StringUtils.isBlank(oferInsts.getSubsidyAmt())?null: Long.valueOf(oferInsts.getSubsidyAmt()));
//            prodOfferInstBaseBO.setNetChannel(org.apache.commons.lang.StringUtils.isBlank(oferInsts.getNetChannel())? null:oferInsts.getNetChannel());
//            try {
//                prodOfferInstBaseBO.setAcceptDate(org.apache.commons.lang.StringUtils.isBlank(oferInsts.getAcceptDate()) ? null : new SimpleDateFormat("yyyy/MM/dd").parse(oferInsts.getAcceptDate()));
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
//            prodOfferInstBaseBO.setUserType(org.apache.commons.lang.StringUtils.isBlank(oferInsts.getUserType())? null :oferInsts.getUserType());
//            prodOfferInstBaseBO.setUserSubType(org.apache.commons.lang.StringUtils.isBlank(oferInsts.getUserSubType())? null:oferInsts.getUserSubType());
//            prodOfferInstBaseBOS.add(prodOfferInstBaseBO);
//        }
//        return prodOfferInstBaseBOS;
//    }

}
