package com.test.dubboDemo.provider;

import java.io.Serializable;
import java.util.Date;

public class BaseRequestDTO implements Serializable {
    private static final long serialVersionUID = 4951945604949342405L;
    private String requestSystem;
    private String traceLogId;
    private Date createdAt;
    private String createdBy;
    private Date updatedAt;
    private String updatedBy;

    public BaseRequestDTO() {
    }

    public String getRequestSystem() {
        return this.requestSystem;
    }

    public String getTraceLogId() {
        return this.traceLogId;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public String getCreatedBy() {
        return this.createdBy;
    }

    public Date getUpdatedAt() {
        return this.updatedAt;
    }

    public String getUpdatedBy() {
        return this.updatedBy;
    }

    public void setRequestSystem(String requestSystem) {
        this.requestSystem = requestSystem;
    }

    public void setTraceLogId(String traceLogId) {
        this.traceLogId = traceLogId;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String toString() {
        return "BaseRequestDTO(requestSystem=" + this.getRequestSystem() + ", traceLogId=" + this.getTraceLogId() + ", createdAt=" + this.getCreatedAt() + ", createdBy=" + this.getCreatedBy() + ", updatedAt=" + this.getUpdatedAt() + ", updatedBy=" + this.getUpdatedBy() + ")";
    }
}
