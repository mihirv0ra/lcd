package com.lightningcd.api.service;

import com.lightningcd.api.Application;
import com.lightningcd.api.model.Component;
import com.lightningcd.api.model.Environment;
import com.lightningcd.api.model.MarathonDeployedAppList;
import com.lightningcd.api.repository.MarathonProvisionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by sqa756 on 11/18/15.
 */
public class MesosDeploymentServiceImpl implements MarathonDeploymentService{

    private static final Logger logger = LoggerFactory.getLogger(DeployApplicationServiceImpl.class);
    private final MarathonProvisionRepository marathonProvisionRepository;

    public MesosDeploymentServiceImpl(MarathonProvisionRepository marathonProvisionRepository) {
        this.marathonProvisionRepository = marathonProvisionRepository;
    }

    /**
     * Fetches a all the applications deployed to a Marathon Cluster.
     *
     * @param application
     * @param component
     * @param environment
     * @return MarathonDeployedAppList of all apps deployed to Marathon
     */
    @Override
    public MarathonDeployedAppList get(Application application, Component component, Environment environment) {
        return null;
    }

    /**
     * Fetches a DeployApplication Object
     *
     * @param componentName unique identifier
     * @return MarathonDeployedApp
     */
    @Override
    public MarathonDeployedAppList get(String componentName) {
        return null;
    }

    /**
     * Creates a new Users and saves it to the store.
     *
     * @param applicationName
     * @param environment
     * @param component
     * @return newly created DeploymentApplication object
     */
    @Override
    public String deploy(String applicationName, Environment environment, Component component) {
        return null;
    }

    @Override
    public void delete(String applicationName, Environment environment, Component component) {

    }
}
