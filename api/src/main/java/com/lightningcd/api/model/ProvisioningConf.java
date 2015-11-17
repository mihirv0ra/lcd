package com.lightningcd.api.model;


import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "provisioningconf")
public class ProvisioningConf extends BaseModel {

    @Indexed(unique = true)
    private String applicationName;
    private ProvisionEnv[] restEndPoint;

    public ProvisioningConf(String applicationName, ProvisionEnv[] restEndPoint) {
        this.applicationName = applicationName;
        this.restEndPoint = restEndPoint;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public ProvisionEnv[] getRestEndPoint() {
        return restEndPoint;
    }

    public void setRestEndPoint(ProvisionEnv[] restEndPoint) {
        this.restEndPoint = restEndPoint;
    }
}
