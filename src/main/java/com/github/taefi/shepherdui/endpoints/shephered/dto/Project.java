package com.github.taefi.shepherdui.endpoints.shephered.dto;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

public class Project implements Serializable {

    private ProjectId id;
    private String description;
    private String webpage;
    private GitRepo gitRepo;
    private ProjectOwner projectOwner;
    private ProjectRuntime projectRuntime;
    private BuildSpec buildSpec;
    private Publication publication = new Publication();
    private Set<Service> additionalServices = Set.of();

    public Project() {
    }

    public ProjectId getId() {
        return id;
    }

    public void setId(ProjectId id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWebpage() {
        return webpage;
    }

    public void setWebpage(String webpage) {
        this.webpage = webpage;
    }

    public GitRepo getGitRepo() {
        return gitRepo;
    }

    public void setGitRepo(GitRepo gitRepo) {
        this.gitRepo = gitRepo;
    }

    public ProjectOwner getProjectOwner() {
        return projectOwner;
    }

    public void setProjectOwner(ProjectOwner projectOwner) {
        this.projectOwner = projectOwner;
    }

    public ProjectRuntime getProjectRuntime() {
        return projectRuntime;
    }

    public void setProjectRuntime(ProjectRuntime projectRuntime) {
        this.projectRuntime = projectRuntime;
    }

    public BuildSpec getBuildSpec() {
        return buildSpec;
    }

    public void setBuildSpec(BuildSpec buildSpec) {
        this.buildSpec = buildSpec;
    }

    public Publication getPublication() {
        return publication;
    }

    public void setPublication(Publication publication) {
        this.publication = publication;
    }

    public Set<Service> getAdditionalServices() {
        return additionalServices;
    }

    public void setAdditionalServices(Set<Service> additionalServices) {
        this.additionalServices = additionalServices;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return Objects.equals(getId(), project.getId()) && Objects.equals(getDescription(), project.getDescription()) && Objects.equals(getWebpage(), project.getWebpage()) && Objects.equals(getGitRepo(), project.getGitRepo()) && Objects.equals(getProjectOwner(), project.getProjectOwner()) && Objects.equals(getProjectRuntime(), project.getProjectRuntime()) && Objects.equals(getBuildSpec(), project.getBuildSpec()) && Objects.equals(getPublication(), project.getPublication()) && Objects.equals(getAdditionalServices(), project.getAdditionalServices());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDescription(), getWebpage(), getGitRepo(), getProjectOwner(), getProjectRuntime(), getBuildSpec(), getPublication(), getAdditionalServices());
    }
}
