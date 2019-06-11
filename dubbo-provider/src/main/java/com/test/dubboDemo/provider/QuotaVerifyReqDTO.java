package com.test.dubboDemo.provider;

    public class QuotaVerifyReqDTO extends BaseRequestDTO {
        private String digitalCode;
        private String success;
        public QuotaVerifyReqDTO() {
        }

        public String getDigitalCode() {
            return this.digitalCode;
        }

        public void setDigitalCode(String digitalCode) {
            this.digitalCode = digitalCode;
        }

        public String getSuccess() {
            return success;
        }

        public void setSuccess(String success) {
            this.success = success;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            } else if (!(o instanceof QuotaVerifyReqDTO)) {
                return false;
            } else {
                QuotaVerifyReqDTO other = (QuotaVerifyReqDTO)o;
                if (!other.canEqual(this)) {
                    return false;
                } else {
                    Object this$digitalCode = this.getDigitalCode();
                    Object other$digitalCode = other.getDigitalCode();
                    if (this$digitalCode == null) {
                        if (other$digitalCode != null) {
                            return false;
                        }
                    } else if (!this$digitalCode.equals(other$digitalCode)) {
                        return false;
                    }

                    return true;
                }
            }
        }

        protected boolean canEqual(Object other) {
            return other instanceof QuotaVerifyReqDTO;
        }


        public String toString() {
            return "QuotaVerifyReqDTO(digitalCode=" + this.getDigitalCode() + ")";
        }

    }
