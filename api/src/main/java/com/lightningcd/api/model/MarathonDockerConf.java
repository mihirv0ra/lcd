package com.lightningcd.api.model;

import java.util.List;

/**
 * Created by sqa756 on 11/22/15.
 */
public class MarathonDockerConf {

    private String image;
    private String network;
    private List<MarathonDockerPortMap> marathonDockerPortMapList;
    private boolean privileged;
    private boolean forcePullImage;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public List<MarathonDockerPortMap> getMarathonDockerPortMapList() {
        return marathonDockerPortMapList;
    }

    public void setMarathonDockerPortMapList(List<MarathonDockerPortMap> marathonDockerPortMapList) {
        this.marathonDockerPortMapList = marathonDockerPortMapList;
    }

    public boolean isPrivileged() {
        return privileged;
    }

    public void setPrivileged(boolean privileged) {
        this.privileged = privileged;
    }

    public boolean isForcePullImage() {
        return forcePullImage;
    }

    public void setForcePullImage(boolean forcePullImage) {
        this.forcePullImage = forcePullImage;
    }
}
