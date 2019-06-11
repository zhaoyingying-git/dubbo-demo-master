package com.test.dubboDemo.provider;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;


@Getter
@Setter
@ToString(callSuper = true, exclude = {"userIdCode"})
public class CrmQueryCommonBo{

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 用户姓名
     */
    private String userName;

    /**
     * 证件类型
     */
    private String userIdType;

    /**
     * 身份证号
     */
    private String userIdCode;
    /**
     * 用户等级
     * 用户电信套餐等级
     * 1-1星级
     * 2-2星级
     * 3-3星级
     * 4-4星级
     * 5-5星级
     * 6-6星级
     * 7-7星级
     */
    private String userGrade;

    /**
     * 手机号
     */
    private String cellphone;

    /**
     * 客户性别：
     * 00-male
     * 01-female
     */
    private String userSex;

    /**
     * 用户生日
     */
    private Date userBirth;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserIdType() {
        return userIdType;
    }

    public void setUserIdType(String userIdType) {
        this.userIdType = userIdType;
    }

    public String getUserIdCode() {
        return userIdCode;
    }

    public void setUserIdCode(String userIdCode) {
        this.userIdCode = userIdCode;
    }

    public String getUserGrade() {
        return userGrade;
    }

    public void setUserGrade(String userGrade) {
        this.userGrade = userGrade;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public Date getUserBirth() {
        return userBirth;
    }

    public void setUserBirth(Date userBirth) {
        this.userBirth = userBirth;
    }

    public String getContactAddress() {
        return contactAddress;
    }

    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDisassembleDate() {
        return disassembleDate;
    }

    public void setDisassembleDate(Date disassembleDate) {
        this.disassembleDate = disassembleDate;
    }

    public String getRiskRank() {
        return riskRank;
    }

    public void setRiskRank(String riskRank) {
        this.riskRank = riskRank;
    }

    public String getNetAge() {
        return netAge;
    }

    public void setNetAge(String netAge) {
        this.netAge = netAge;
    }

    public String getNetChannel() {
        return netChannel;
    }

    public void setNetChannel(String netChannel) {
        this.netChannel = netChannel;
    }

    public String getIMEI() {
        return IMEI;
    }

    public void setIMEI(String IMEI) {
        this.IMEI = IMEI;
    }

    public String getMobileHCode() {
        return mobileHCode;
    }

    public void setMobileHCode(String mobileHCode) {
        this.mobileHCode = mobileHCode;
    }

    public boolean isViceCard() {
        return viceCard;
    }

    public void setViceCard(boolean viceCard) {
        this.viceCard = viceCard;
    }

    public boolean isDisassembleFlag() {
        return disassembleFlag;
    }

    public void setDisassembleFlag(boolean disassembleFlag) {
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

    public String getValueRank() {
        return valueRank;
    }

    public void setValueRank(String valueRank) {
        this.valueRank = valueRank;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public List<ProdOfferInstBaseBO> getProdOfferInstBaseBOS() {
        return prodOfferInstBaseBOS;
    }

    public void setProdOfferInstBaseBOS(List<ProdOfferInstBaseBO> prodOfferInstBaseBOS) {
        this.prodOfferInstBaseBOS = prodOfferInstBaseBOS;
    }

    public Long getProdInstId() {
        return prodInstId;
    }

    public void setProdInstId(Long prodInstId) {
        this.prodInstId = prodInstId;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getProNoType() {
        return proNoType;
    }

    public void setProNoType(String proNoType) {
        this.proNoType = proNoType;
    }

    public String getQueryType() {
        return queryType;
    }

    public void setQueryType(String queryType) {
        this.queryType = queryType;
    }

    public String getTelcoCode() {
        return telcoCode;
    }

    public void setTelcoCode(String telcoCode) {
        this.telcoCode = telcoCode;
    }

    public String getUserNameAlias() {
        return userNameAlias;
    }

    public void setUserNameAlias(String userNameAlias) {
        this.userNameAlias = userNameAlias;
    }

    public String getUserIdCodeAlias() {
        return userIdCodeAlias;
    }

    public void setUserIdCodeAlias(String userIdCodeAlias) {
        this.userIdCodeAlias = userIdCodeAlias;
    }

    /**

     * 客户联系地址
     */
    private String contactAddress;
    /**
     * 状态: 欠费、停机状态(单停，双停)，挂失，未实名等
     */
    private String status;
    /**
     * 拆机时间
     */
    private Date disassembleDate;

    /**
     * 风险等级 离网倾向
     */
    private String riskRank;

    /**
     * 入网年限  网龄
     */
    private String netAge;

    /**
     * 入网渠道
     */
    private String netChannel;

    /**
     * 终端串码
     */
    private String IMEI;
    /**
     * sim卡号
     */
    private String mobileHCode;
    /**
     * 是否副卡
     */
    private boolean viceCard;

    /**
     * 是否拆机
     */
    private boolean disassembleFlag;

    /**
     * 营业厅ID
     */
    private String hallNo;
    /**
     * 营业厅地址
     */
    private String hallAddress;
    /**
     * 价值等级   省公司给用户评级
     */
    private String valueRank;
    /**
     * 套餐完成时间
     */
    private Date finishDate;
    /**
     * 销售品实例列表
     */
    private List<ProdOfferInstBaseBO> prodOfferInstBaseBOS;

    /**
     * 产品实例标识
     */
    private Long prodInstId;
    /**
     * 验签报文
     */
    private String sign;

    /**
     * 区号
     */
    private String areaCode;

    /**
     * 省份编码
     */
    private String provinceCode;

    /**
     * 号码类型 1：接入号码 2：宽带账号 3： 手机号码，默认手机号码
     */
    private String proNoType;

    /**
     * 查询范围:0-所有销售品，1-仅主销售品，2- 仅附属销售品   默认查询所有的套餐
     */
    private String queryType;

    /**
     * 电信编码
     */
    private String telcoCode;


    /**
     * 用户姓名别名
     */
    private String userNameAlias;


    /**
     * 身份证号别名
     */
    private String userIdCodeAlias;

}