package com.github.taefi.shepherdui.endpoints.shephered.dto;

import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

public class BuildSpec implements Serializable {

    private Resources resources;
    private Map<String, String> buildArgs = Map.of();

    private String dockerFile;

    public BuildSpec() {
    }

    public BuildSpec(Resources resources, Map<String, String> buildArgs, String dockerFile) {
        this.resources = resources;
        this.buildArgs = buildArgs;
        this.dockerFile = dockerFile;
    }

    public Resources getResources() {
        return resources;
    }

    public void setResources(Resources resources) {
        this.resources = resources;
    }

    public Map<String, String> getBuildArgs() {
        return buildArgs;
    }

    public void setBuildArgs(Map<String, String> buildArgs) {
        this.buildArgs = buildArgs;
    }

    public String getDockerFile() {
        return dockerFile;
    }

    public void setDockerFile(String dockerFile) {
        this.dockerFile = dockerFile;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BuildSpec buildSpec = (BuildSpec) o;
        return Objects.equals(getResources(), buildSpec.getResources()) && Objects.equals(getBuildArgs(), buildSpec.getBuildArgs()) && Objects.equals(getDockerFile(), buildSpec.getDockerFile());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getResources(), getBuildArgs(), getDockerFile());
    }
}
