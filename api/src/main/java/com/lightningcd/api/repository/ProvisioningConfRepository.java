package com.lightningcd.api.repository;


import com.lightningcd.api.model.ProvisioningConf;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProvisioningConfRepository extends MongoRepository<ProvisioningConf, ObjectId> {

    ProvisioningConf findByApplicationName(String applicationName);

}
