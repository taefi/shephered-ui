package com.github.taefi.shepherdui.endpoints.shephered.dto;

import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

public class ProjectRuntime implements Serializable {
    private Resources resources;
    private Map<String, String> envVars = Map.of();

    public ProjectRuntime() {
    }

    public ProjectRuntime(Resources resources, Map<String, String> envVars) {
        this.resources = resources;
        this.envVars = envVars;
    }

    public Resources getResources() {
        return resources;
    }

    public void setResources(Resources resources) {
        this.resources = resources;
    }

    public Map<String, String> getEnvVars() {
        return envVars;
    }

    public void setEnvVars(Map<String, String> envVars) {
        this.envVars = envVars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectRuntime that = (ProjectRuntime) o;
        return Objects.equals(getResources(), that.getResources()) && Objects.equals(getEnvVars(), that.getEnvVars());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getResources(), getEnvVars());
    }
}
