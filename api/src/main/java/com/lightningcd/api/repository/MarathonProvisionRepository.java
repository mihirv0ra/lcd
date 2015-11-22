package com.lightningcd.api.repository;

import com.lightningcd.api.model.MarathonDeployedAppList;

/**
 * Created by sqa756 on 11/22/15.
 */
public interface MarathonProvisionRepository {

    MarathonDeployedAppList getAllApps();

    MarathonDeployedAppList getAppsByID(String id);

}
