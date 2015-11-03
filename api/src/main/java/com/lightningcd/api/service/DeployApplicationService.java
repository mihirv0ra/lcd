package com.lightningcd.api.service;


import com.lightningcd.api.exception.DeployApplicationNotFoundException;
import com.lightningcd.api.model.Component;
import com.lightningcd.api.model.DeployApplication;
import com.lightningcd.api.model.Environment;
import org.bson.types.ObjectId;


public interface DeployApplicationService {


    /**
     * Fetches all registered applications.
     *
     * @return all DeployApplication
     */
    Iterable<DeployApplication> all();


    /**
     * Fetches a DeployApplication Object.
     *
     * @param id deployapplication unique identifier
     * @return DeployApplication instance
     */
    DeployApplication get(ObjectId id);

    /**
     * Fetches a DeployApplication Object
     *
     * @param applicationName unique identifier
     * @return DeployApplication object
     */

    DeployApplication get(String applicationName);

    /**
     * Creates a new Users and saves it to the store.
     *
     * @return newly created DeploymentApplication object
     */
    String create(String applicationName, Environment[] environments, Component[] components, String provisioningTypes);

    /**
     * Updates an existing deployapplication instance.
     *
     * @param applicationName   to update
     * @param environments      to update
     * @param components        to update
     * @param provisioningTypes to Update
     * @return updated deployApplication instance
     */
    String update(ObjectId id, String applicationName, Environment[] environments, Component[] components, String provisioningTypes) throws DeployApplicationNotFoundException;

    /**
     * Deletes an existing DeployApplication instance.
     *
     * @param id unique identifier of deployApplication to delete
     */
    void delete(ObjectId id);

    /**
     * Deletes an existing deployApplication instance
     */
    String delete(String applicationName);
}
