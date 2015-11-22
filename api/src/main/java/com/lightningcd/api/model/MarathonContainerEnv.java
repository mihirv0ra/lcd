package com.lightningcd.api.model;

import java.util.HashMap;

/**
 * Created by sqa756 on 11/22/15.
 */
public class MarathonContainerEnv {

        private HashMap<String,String> envPropMap;

        public HashMap<String, String> getEnvPropMap() {
                return envPropMap;
        }

        public void setEnvPropMap(HashMap<String, String> envPropMap) {
                this.envPropMap = envPropMap;
        }
}
