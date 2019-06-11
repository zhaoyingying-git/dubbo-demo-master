package com.test.dubboDemo.provider;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @Auther: wangjiawen
 * @Date: 2018/11/21 10:57
 * @Description:  销售品实例信息
 */

public class ProdOfferInstBaseBO implements Serializable {

    private static final long serialVersionUID = -6351646750058266385L;

    /**
     * 销售品实例标识
     */
    private String  offerInstId;
    /**
    销售品标识
     */
    private String prodOfferId;
    /**
     * 销售品名称
     */
    private String prodOfferName;
    /**
    *销售品每月缴纳金额
     */
    private String prodOfferAmt;
    /**
     * 销售品类型
     */
    private String prodOfferType;
    /**
     * 销售品月返回金额
     */
    private Long prodMonthRetAmt;
    /**
     * 套餐补贴金额  套餐每月补贴金额
     */
    private Long subsidyAmt;
    /**
     * 生效时间
     */
    private Date effDate;
    /**
     * 过期时间
     */
    private Date expDate;
    /**
    *销售品状态ENABLE/DISABLE
     */
    private String statusCd;
    /**
     * 入网渠道
     */
    private String netChannel;
    /*
     * 客户群体
     * 1-家庭用户,2-个人用户,3-政企用户
     */
    private String userType;
    /*
     * 政企用户
     * 1-商业用户,2-行业用户,3-校园用户
     */
    private String userSubType;
    /**
     * 受理时间
     */
    private Date acceptDate;
    /**
     * 受理员工标识
     */
    private Long createStaff;
    /**
     * 受理渠道标识
     */
    private Long createOrgId;
    /**
     * 受理渠道名称
     */
    private Long createOrgName;

    /**
     * 套餐订单号
     */
    private String  packageOrderNo;


    /**
     * 自定义获取实例id和销售品id的值，防止排序null导致的错误
     * @return
     */
    public String getCustomOfferInstId(){
        if(null == offerInstId){
            return "";
        }
        return offerInstId;
    }
    public String getCustomProdOfferId(){
        if(null == prodOfferId){
            return "";
        }
        return prodOfferId;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getOfferInstId() {
        return offerInstId;
    }

    public void setOfferInstId(String offerInstId) {
        this.offerInstId = offerInstId;
    }

    public String getProdOfferId() {
        return prodOfferId;
    }

    public void setProdOfferId(String prodOfferId) {
        this.prodOfferId = prodOfferId;
    }

    public String getProdOfferName() {
        return prodOfferName;
    }

    public void setProdOfferName(String prodOfferName) {
        this.prodOfferName = prodOfferName;
    }

    public String getProdOfferAmt() {
        return prodOfferAmt;
    }

    public void setProdOfferAmt(String prodOfferAmt) {
        this.prodOfferAmt = prodOfferAmt;
    }

    public String getProdOfferType() {
        return prodOfferType;
    }

    public void setProdOfferType(String prodOfferType) {
        this.prodOfferType = prodOfferType;
    }

    public Long getProdMonthRetAmt() {
        return prodMonthRetAmt;
    }

    public void setProdMonthRetAmt(Long prodMonthRetAmt) {
        this.prodMonthRetAmt = prodMonthRetAmt;
    }

    public Long getSubsidyAmt() {
        return subsidyAmt;
    }

    public void setSubsidyAmt(Long subsidyAmt) {
        this.subsidyAmt = subsidyAmt;
    }

    public Date getEffDate() {
        return effDate;
    }

    public void setEffDate(Date effDate) {
        this.effDate = effDate;
    }

    public Date getExpDate() {
        return expDate;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }

    public String getStatusCd() {
        return statusCd;
    }

    public void setStatusCd(String statusCd) {
        this.statusCd = statusCd;
    }

    public String getNetChannel() {
        return netChannel;
    }

    public void setNetChannel(String netChannel) {
        this.netChannel = netChannel;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserSubType() {
        return userSubType;
    }

    public void setUserSubType(String userSubType) {
        this.userSubType = userSubType;
    }

    public Date getAcceptDate() {
        return acceptDate;
    }

    public void setAcceptDate(Date acceptDate) {
        this.acceptDate = acceptDate;
    }

    public Long getCreateStaff() {
        return createStaff;
    }

    public void setCreateStaff(Long createStaff) {
        this.createStaff = createStaff;
    }

    public Long getCreateOrgId() {
        return createOrgId;
    }

    public void setCreateOrgId(Long createOrgId) {
        this.createOrgId = createOrgId;
    }

    public Long getCreateOrgName() {
        return createOrgName;
    }

    public void setCreateOrgName(Long createOrgName) {
        this.createOrgName = createOrgName;
    }

    public String getPackageOrderNo() {
        return packageOrderNo;
    }

    public void setPackageOrderNo(String packageOrderNo) {
        this.packageOrderNo = packageOrderNo;
    }
}
