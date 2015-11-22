package com.lightningcd.api.model;

/**
 * Created by sqa756 on 11/22/15.
 */
public class MarathonDockerVolumeMap {

    private String containerPath;
    private String hostPath;
    private String mode;

    public String getContainerPath() {
        return containerPath;
    }

    public void setContainerPath(String containerPath) {
        this.containerPath = containerPath;
    }

    public String getHostPath() {
        return hostPath;
    }

    public void setHostPath(String hostPath) {
        this.hostPath = hostPath;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }
}
