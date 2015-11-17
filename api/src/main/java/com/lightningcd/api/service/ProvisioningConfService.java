package com.lightningcd.api.service;


import com.lightningcd.api.exception.ConfigurationNotFoundException;
import com.lightningcd.api.model.ProvisioningConf;
import org.bson.types.ObjectId;

public interface ProvisioningConfService {

    /**
     * Fetches all registered configurations.
     *
     * @return all ProvisioningConf
     */
    Iterable<ProvisioningConf> all();


    /**
     * Fetches a ProvisioningConf Object
     *
     * @param id ProvisioningConf unique identifier
     * @return ProvisioningConf instance
     */
    ProvisioningConf get(ObjectId id);

    /**
     * Fetches a ProvisionConf Object
     *
     * @param applicationName unique identifier
     * @return ProvisioningConf object
     */

    ProvisioningConf get(String applicationName);

    /**
     * Creates a new ProvisioningConfiguration and saves it.
     *
     * @return applicationName
     */
    String create(ProvisioningConf provisioningConf);

    /**
     * Updates an existing ProvisionConfiguration.
     *
     * @return applicationName
     */
    String update(ProvisioningConf provisionConf) throws ConfigurationNotFoundException;


    /**
     * Deletes an existing ProvisioningConfiguration
     */
    String delete(String applicationName);
}
