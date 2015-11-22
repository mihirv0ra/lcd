package com.lightningcd.api.model;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by mv012004 on 11/21/15.
 * Model for defining what the MarathonProvisioning Configuration will look like
 */



@Document(collection = "marathonProvisioningConf")
public class MarathonProvisioningConf {

    @Indexed(unique = true)
    private String componentName;
    private String id;
    private int instances;
    private int cpu;
    private int memory;
    private MarathonContainerEnv marathonContainerEnv;
    private MarathonContainerConfDoc marathonContainerConfDoc;

    public MarathonProvisioningConf(){

    }

    public MarathonProvisioningConf(String componentName, String id, int instances, int cpu, int memory, MarathonContainerEnv marathonContainerEnv, MarathonContainerConfDoc marathonContainerConfDoc) {
        this.componentName = componentName;
        this.id = id;
        this.instances = instances;
        this.cpu = cpu;
        this.memory = memory;
        this.marathonContainerEnv = marathonContainerEnv;
        this.marathonContainerConfDoc = marathonContainerConfDoc;
    }

    public String getComponentName() {
        return componentName;
    }

    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getInstances() {
        return instances;
    }

    public void setInstances(int instances) {
        this.instances = instances;
    }

    public int getCpu() {
        return cpu;
    }

    public void setCpu(int cpu) {
        this.cpu = cpu;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public MarathonContainerEnv getMarathonContainerEnv() {
        return marathonContainerEnv;
    }

    public void setMarathonContainerEnv(MarathonContainerEnv marathonContainerEnv) {
        this.marathonContainerEnv = marathonContainerEnv;
    }

    public MarathonContainerConfDoc getMarathonContainerConfDoc() {
        return marathonContainerConfDoc;
    }

    public void setMarathonContainerConfDoc(MarathonContainerConfDoc marathonContainerConfDoc) {
        this.marathonContainerConfDoc = marathonContainerConfDoc;
    }
}
