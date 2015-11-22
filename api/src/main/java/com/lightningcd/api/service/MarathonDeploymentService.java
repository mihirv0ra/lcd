package com.lightningcd.api.service;

import com.lightningcd.api.Application;
import com.lightningcd.api.exception.DeployApplicationNotFoundException;
import com.lightningcd.api.model.*;

/**
 * Created by sqa756 on 11/18/15.
 */
public interface MarathonDeploymentService {

    /**
     * Fetches a all the applications deployed to a Marathon Cluster.
     *
     * @return MarathonDeployedAppList of all apps deployed to Marathon
     */
    MarathonDeployedAppList get(Application application,Component component,Environment environment);

    /**
     * Fetches a DeployApplication Object
     *
     * @param componentName unique identifier
     * @return MarathonDeployedApp
     */

    MarathonDeployedAppList get(String componentName);

    /**
     * Creates a new Users and saves it to the store.
     *
     * @return newly created DeploymentApplication object
     */
    String deploy(String applicationName, Environment environment, Component component);

    /**
     * Updates an existing deployapplication instance.
     *
     * @return updated deployApplication instance
     */
    //String update(DeployApplication newData) throws DeployApplicationNotFoundException;

    /**
     * Undeploys an existing Deployed application from the Marathon Cluster.
     *
     * @param applicationName
     * @param component
     * @param environment
     */
    void delete(String applicationName, Environment environment, Component component);


}
