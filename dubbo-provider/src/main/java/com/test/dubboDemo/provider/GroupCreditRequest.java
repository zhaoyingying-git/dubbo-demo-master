package com.test.dubboDemo.provider;

import lombok.*;

import java.util.List;

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
public class GroupCreditRequest {


        private String certType;


        public String getCertType() {
                return certType;
        }

        public void setCertType(String certType) {
                this.certType = certType;
        }

        public String getCertNum() {
                return certNum;
        }

        public void setCertNum(String certNum) {
                this.certNum = certNum;
        }

        public String getCustName() {
                return custName;
        }

        public void setCustName(String custName) {
                this.custName = custName;
        }

        public Long getDigitalCode() {
                return digitalCode;
        }

        public void setDigitalCode(Long digitalCode) {
                this.digitalCode = digitalCode;
        }

        public Integer getCreditLine() {
                return creditLine;
        }

        public void setCreditLine(Integer creditLine) {
                this.creditLine = creditLine;
        }

        public String getCreditType() {
                return creditType;
        }

        public void setCreditType(String creditType) {
                this.creditType = creditType;
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

        public List<GroupRateInfoRequest> getGroupRateInfoRequests() {
                return groupRateInfoRequests;
        }

        public void setGroupRateInfoRequests(List<GroupRateInfoRequest> groupRateInfoRequests) {
                this.groupRateInfoRequests = groupRateInfoRequests;
        }

        private String certNum;


        private String custName;


        private Long digitalCode;


        private Integer creditLine;


        private String creditType;


        private String effDate;


        private String expDate;

        private List<GroupRateInfoRequest> groupRateInfoRequests;
}
