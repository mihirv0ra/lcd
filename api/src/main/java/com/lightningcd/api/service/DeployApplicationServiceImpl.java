package com.lightningcd.api.service;


import com.lightningcd.api.exception.DeployApplicationNotFoundException;
import com.lightningcd.api.model.Component;
import com.lightningcd.api.model.DeployApplication;
import com.lightningcd.api.model.Environment;
import com.lightningcd.api.repository.DeployApplicationRepository;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeployApplicationServiceImpl implements DeployApplicationService {

    private static final Logger logger = LoggerFactory.getLogger(DeployApplicationServiceImpl.class);
    private final DeployApplicationRepository deployApplicationRepository;

    @Autowired
    public DeployApplicationServiceImpl(
            DeployApplicationRepository deployApplicationRepository) {
        this.deployApplicationRepository = deployApplicationRepository;
    }

    /**
     * Fetches all registered applications.
     *
     * @return all DeployApplication
     */
    @Override
    public Iterable<DeployApplication> all() {
        return null;
    }

    /**
     * Fetches an DeployApplication Object.
     *
     * @param id deployapplication unique identifier
     * @return DeployApplication instance
     */
    @Override
    public DeployApplication get(ObjectId id) {

        DeployApplication deployApplication = deployApplicationRepository.findOne(id);
        return deployApplication;
    }

    @Override
    public DeployApplication get(String applicationName) {
        logger.info("ApplicationName:" + applicationName);
        DeployApplication deployApplication = deployApplicationRepository.findByApplicationName(applicationName);
        return deployApplication;
    }

    /**
     * Creates a new Users and saves it to the store.
     *
     * @param applicationName
     * @param environments
     * @param components
     * @param provisioningTypes @return newly created DeploymentApplication object
     */
    @Override
    public String create(String applicationName, Environment[] environments, Component[] components, String provisioningTypes) {
        DeployApplication deployApplication = new DeployApplication(applicationName,environments,components,provisioningTypes);
        deployApplicationRepository.save(deployApplication);
        return deployApplication.getApplicationName();
    }

    /**
     * Updates an existing deployapplication instance.
     *
     * @param applicationName   to update
     * @param environments      to update
     * @param components        to update
     * @param provisioningTypes to Update
     * @return updated deployApplication instance
     */
    @Override
    public String update(ObjectId id, String applicationName, Environment[] environments, Component[] components, String provisioningTypes) throws DeployApplicationNotFoundException {
        DeployApplication deployApplication = deployApplicationRepository.findOne(id);
        if (null != deployApplication) {
            System.out.println("applicationName at saving time:" + applicationName);
            deployApplication.setApplicationName(applicationName);
            deployApplication.setEnvironments(environments);
            deployApplication.setComponent(components);
            deployApplication.setProvisioningTypes(provisioningTypes);

            deployApplicationRepository.save(deployApplication);
            return deployApplication.getApplicationName();
        } else {
            throw new DeployApplicationNotFoundException("Application not found");
        }
    }

    /**
     * Deletes an existing DeployApplication instance.
     *
     * @param id unique identifier of deployApplication to delete
     */
    @Override
    public void delete(ObjectId id) {

        DeployApplication deployApplication = deployApplicationRepository.findOne(id);
        deployApplicationRepository.delete(deployApplication);

    }

    /**
     * Deletes an existing deployApplication instance
     *
     * @param applicationName
     */
    @Override
    public String delete(String applicationName) {

        DeployApplication deployApplication = deployApplicationRepository.findByApplicationName(applicationName);
        deployApplicationRepository.delete(deployApplication);
        return deployApplication.getApplicationName();
    }
}
