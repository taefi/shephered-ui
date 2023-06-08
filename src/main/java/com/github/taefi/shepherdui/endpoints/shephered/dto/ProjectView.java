package com.github.taefi.shepherdui.endpoints.shephered.dto;

import java.io.Serializable;
import java.util.Objects;

public class ProjectView implements Serializable {

    private Project project;
    private Build lastBuild;
    public ProjectView() {
    }
    public ProjectView(Project project, Build lastBuild) {
        this.project = project;
        this.lastBuild = lastBuild;
    }
    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Build getLastBuild() {
        return lastBuild;
    }

    public void setLastBuild(Build lastBuild) {
        this.lastBuild = lastBuild;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectView that = (ProjectView) o;
        return Objects.equals(getProject(), that.getProject()) && Objects.equals(getLastBuild(), that.getLastBuild());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProject(), getLastBuild());
    }
}
