package com.ashzd.apiplatform.entity;

import java.io.Serializable;
import java.util.Date;

public class ApiCollectionInfo implements Serializable {
    private Integer id;

    private String serviceName;

    private String serviceUrl;

    private String serviceVersion;

    private Date createdAt;

    private Date updatedAt;

    private String serviceJsonInfo;

    private static final long serialVersionUID = 1L;

    public ApiCollectionInfo(Integer id, String serviceName, String serviceUrl, String serviceVersion, Date createdAt, Date updatedAt) {
        this.id = id;
        this.serviceName = serviceName;
        this.serviceUrl = serviceUrl;
        this.serviceVersion = serviceVersion;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public ApiCollectionInfo(Integer id, String serviceName, String serviceUrl, String serviceVersion, Date createdAt, Date updatedAt, String serviceJsonInfo) {
        this.id = id;
        this.serviceName = serviceName;
        this.serviceUrl = serviceUrl;
        this.serviceVersion = serviceVersion;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.serviceJsonInfo = serviceJsonInfo;
    }

    public ApiCollectionInfo() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName == null ? null : serviceName.trim();
    }

    public String getServiceUrl() {
        return serviceUrl;
    }

    public void setServiceUrl(String serviceUrl) {
        this.serviceUrl = serviceUrl == null ? null : serviceUrl.trim();
    }

    public String getServiceVersion() {
        return serviceVersion;
    }

    public void setServiceVersion(String serviceVersion) {
        this.serviceVersion = serviceVersion == null ? null : serviceVersion.trim();
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getServiceJsonInfo() {
        return serviceJsonInfo;
    }

    public void setServiceJsonInfo(String serviceJsonInfo) {
        this.serviceJsonInfo = serviceJsonInfo == null ? null : serviceJsonInfo.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", serviceName=").append(serviceName);
        sb.append(", serviceUrl=").append(serviceUrl);
        sb.append(", serviceVersion=").append(serviceVersion);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", updatedAt=").append(updatedAt);
        sb.append(", serviceJsonInfo=").append(serviceJsonInfo);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        ApiCollectionInfo other = (ApiCollectionInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getServiceName() == null ? other.getServiceName() == null : this.getServiceName().equals(other.getServiceName()))
            && (this.getServiceUrl() == null ? other.getServiceUrl() == null : this.getServiceUrl().equals(other.getServiceUrl()))
            && (this.getServiceVersion() == null ? other.getServiceVersion() == null : this.getServiceVersion().equals(other.getServiceVersion()))
            && (this.getCreatedAt() == null ? other.getCreatedAt() == null : this.getCreatedAt().equals(other.getCreatedAt()))
            && (this.getUpdatedAt() == null ? other.getUpdatedAt() == null : this.getUpdatedAt().equals(other.getUpdatedAt()))
            && (this.getServiceJsonInfo() == null ? other.getServiceJsonInfo() == null : this.getServiceJsonInfo().equals(other.getServiceJsonInfo()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getServiceName() == null) ? 0 : getServiceName().hashCode());
        result = prime * result + ((getServiceUrl() == null) ? 0 : getServiceUrl().hashCode());
        result = prime * result + ((getServiceVersion() == null) ? 0 : getServiceVersion().hashCode());
        result = prime * result + ((getCreatedAt() == null) ? 0 : getCreatedAt().hashCode());
        result = prime * result + ((getUpdatedAt() == null) ? 0 : getUpdatedAt().hashCode());
        result = prime * result + ((getServiceJsonInfo() == null) ? 0 : getServiceJsonInfo().hashCode());
        return result;
    }
}