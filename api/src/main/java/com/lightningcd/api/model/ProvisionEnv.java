package com.lightningcd.api.model;


import java.net.URL;

/**
 * This class will serve as a model for holding endpoints for
 * provisioning environments, idea being an application can have
 * different rest endpoints for different application environments.
 */

public class ProvisionEnv {

    private String environmentName;
    private URL restEndPoint;


    public String getEnvironmentName() {
        return environmentName;
    }

    public void setEnvironmentName(String environmentName) {
        this.environmentName = environmentName;
    }

    public URL getRestEndPoint() {
        return restEndPoint;
    }

    public void setRestEndPoint(URL restEndPoint) {
        this.restEndPoint = restEndPoint;
    }
}
