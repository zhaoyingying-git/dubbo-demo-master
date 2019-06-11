package com.test.dubboDemo.provider;

/**
 * 〈${DESCRIPTION}〉
 *
 * @author zhaoyingying
 * @create 2019/3/26
 * @company 甜橙信息
 */

public class GDRequest {

    private String channelCode;//渠道号
    private String version;//接口版本号
    private String timestamp;//调用时间戳
    private String tracelogID;//日志号
    private String cellPhone;//手机号
    private String merchantNo;//商户号
    private String institutionType;//商户类型

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getTracelogID() {
        return tracelogID;
    }

    public void setTracelogID(String tracelogID) {
        this.tracelogID = tracelogID;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getMerchantNo() {
        return merchantNo;
    }

    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo;
    }

    public String getInstitutionType() {
        return institutionType;
    }

    public void setInstitutionType(String institutionType) {
        this.institutionType = institutionType;
    }
}
