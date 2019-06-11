package com.test.dubboDemo.provider;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

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
public class HNPackageBo {
    private String resultCode;
    private String resultMsg;
    private String prodInstId;
    private String prodFinishDate;
    private String userName;
    private String userIdCode;
    private String userBirth;
    private String userSex;
    private String userAddress;
    private String userGrade;
    private String netAge;
    private String imei;
    private String simCode;
    private String viceCardFlag;
    private String disassembleFlag;
    private String hallNo;
    private String hallAddress;
    private List<OferInsts> offerInsts;

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public String getProdInstId() {
        return prodInstId;
    }

    public void setProdInstId(String prodInstId) {
        this.prodInstId = prodInstId;
    }

    public String getProdFinishDate() {
        return prodFinishDate;
    }

    public void setProdFinishDate(String prodFinishDate) {
        this.prodFinishDate = prodFinishDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserIdCode() {
        return userIdCode;
    }

    public void setUserIdCode(String userIdCode) {
        this.userIdCode = userIdCode;
    }

    public String getUserBirth() {
        return userBirth;
    }

    public void setUserBirth(String userBirth) {
        this.userBirth = userBirth;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserGrade() {
        return userGrade;
    }

    public void setUserGrade(String userGrade) {
        this.userGrade = userGrade;
    }

    public String getNetAge() {
        return netAge;
    }

    public void setNetAge(String netAge) {
        this.netAge = netAge;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getSimCode() {
        return simCode;
    }

    public void setSimCode(String simCode) {
        this.simCode = simCode;
    }

    public String getViceCardFlag() {
        return viceCardFlag;
    }

    public void setViceCardFlag(String viceCardFlag) {
        this.viceCardFlag = viceCardFlag;
    }

    public String getDisassembleFlag() {
        return disassembleFlag;
    }

    public void setDisassembleFlag(String disassembleFlag) {
        this.disassembleFlag = disassembleFlag;
    }

    public String getHallNo() {
        return hallNo;
    }

    public void setHallNo(String hallNo) {
        this.hallNo = hallNo;
    }

    public String getHallAddress() {
        return hallAddress;
    }

    public void setHallAddress(String hallAddress) {
        this.hallAddress = hallAddress;
    }

    public List<OferInsts> getOfferInsts() {
        return offerInsts;
    }

    public void setOfferInsts(List<OferInsts> offerInsts) {
        this.offerInsts = offerInsts;
    }

    @Override
    public String toString() {
        return "HNPackageBo{" +
                "resultCode='" + resultCode + '\'' +
                ", resultMsg='" + resultMsg + '\'' +
                ", prodInstId='" + prodInstId + '\'' +
                ", prodFinishDate='" + prodFinishDate + '\'' +
                ", userName='" + userName + '\'' +
                ", userIdCode='" + userIdCode + '\'' +
                ", userBirth='" + userBirth + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", userGrade='" + userGrade + '\'' +
                ", netAge='" + netAge + '\'' +
                ", imei='" + imei + '\'' +
                ", simCode='" + simCode + '\'' +
                ", viceCardFlag='" + viceCardFlag + '\'' +
                ", disassembleFlag='" + disassembleFlag + '\'' +
                ", hallNo='" + hallNo + '\'' +
                ", hallAddress='" + hallAddress + '\'' +
                ", offerInsts=" + offerInsts +
                '}';
    }
}
