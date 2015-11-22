package com.lightningcd.api.model;

import java.util.List;

/**
 * Created by sqa756 on 11/22/15.
 */
public class MarathonContainerConfDoc {

    private String type;
    private List<MarathonDockerVolumeMap> marathonDockerVolumeMapList;
    private MarathonDockerConf marathonDockerConf;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<MarathonDockerVolumeMap> getMarathonDockerVolumeMapList() {
        return marathonDockerVolumeMapList;
    }

    public void setMarathonDockerVolumeMapList(List<MarathonDockerVolumeMap> marathonDockerVolumeMapList) {
        this.marathonDockerVolumeMapList = marathonDockerVolumeMapList;
    }

    public MarathonDockerConf getMarathonDockerConf() {
        return marathonDockerConf;
    }

    public void setMarathonDockerConf(MarathonDockerConf marathonDockerConf) {
        this.marathonDockerConf = marathonDockerConf;
    }
}
