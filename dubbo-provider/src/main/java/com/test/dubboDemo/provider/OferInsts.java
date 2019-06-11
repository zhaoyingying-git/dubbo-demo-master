package com.test.dubboDemo.provider;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * 〈${DESCRIPTION}〉
 *
 * @author zhaoyingying
 * @create 2019/04/25
 * @company 甜橙信息
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OferInsts {

    private String offerInstId;
    private String offerId;
    private String offerName;
    private String effDate;
    private String expDate;
    private String statusCd;
    private String acceptDate;
    private String custOrderNbr;
    private String prodOfferAmt;
    private String prodMonthRetAmt;
    private String subsidyAmt;
    private String netChannel;
    private String userType;
    private String userSubType;

    public String getOfferInstId() {
        return offerInstId;
    }

    public void setOfferInstId(String offerInstId) {
        this.offerInstId = offerInstId;
    }

    public String getOfferId() {
        return offerId;
    }

    public void setOfferId(String offerId) {
        this.offerId = offerId;
    }

    public String getOfferName() {
        return offerName;
    }

    public void setOfferName(String offerName) {
        this.offerName = offerName;
    }

    public String getEffDate() {
        return effDate;
    }

    public void setEffDate(String effDate) {
        this.effDate = effDate;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public String getStatusCd() {
        return statusCd;
    }

    public void setStatusCd(String statusCd) {
        this.statusCd = statusCd;
    }

    public String getAcceptDate() {
        return acceptDate;
    }

    public void setAcceptDate(String acceptDate) {
        this.acceptDate = acceptDate;
    }

    public String getCustOrderNbr() {
        return custOrderNbr;
    }

    public void setCustOrderNbr(String custOrderNbr) {
        this.custOrderNbr = custOrderNbr;
    }

    public String getProdOfferAmt() {
        return prodOfferAmt;
    }

    public void setProdOfferAmt(String prodOfferAmt) {
        this.prodOfferAmt = prodOfferAmt;
    }

    public String getProdMonthRetAmt() {
        return prodMonthRetAmt;
    }

    public void setProdMonthRetAmt(String prodMonthRetAmt) {
        this.prodMonthRetAmt = prodMonthRetAmt;
    }

    public String getSubsidyAmt() {
        return subsidyAmt;
    }

    public void setSubsidyAmt(String subsidyAmt) {
        this.subsidyAmt = subsidyAmt;
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
}
