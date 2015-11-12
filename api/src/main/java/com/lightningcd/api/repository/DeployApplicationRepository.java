package com.lightningcd.api.repository;


import com.lightningcd.api.model.DeployApplication;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface DeployApplicationRepository extends MongoRepository<DeployApplication, ObjectId> {


    DeployApplication findByApplicationName(String applicationName);


}