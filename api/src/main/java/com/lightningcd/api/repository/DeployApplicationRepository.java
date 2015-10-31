package com.lightningcd.api.repository;


import com.lightningcd.api.model.DeployApplication;
import org.bson.types.ObjectId;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface DeployApplicationRepository extends PagingAndSortingRepository<DeployApplication, ObjectId>{


    DeployApplication findByApplicationName(String applicationName);


}