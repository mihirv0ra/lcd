package com.lightningcd.api.model;


public class Component {


    private String componentName;
    private String componentType;
    private String componentVersion;
    private String dockerImageTag;
    private String memory;
    private String cpu;


    public String getComponentName() {
        return componentName;
    }

    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }

    public String getComponentType() {
        return componentType;
    }

    public void setComponentType(String componentType) {
        this.componentType = componentType;
    }

    public String getComponentVersion() {
        return componentVersion;
    }

    public void setComponentVersion(String componentVersion) {
        this.componentVersion = componentVersion;
    }


    public String getDockerImageTag() {
        return dockerImageTag;
    }

    public void setDockerImageTag(String dockerImageTag) {
        this.dockerImageTag = dockerImageTag;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }
}
