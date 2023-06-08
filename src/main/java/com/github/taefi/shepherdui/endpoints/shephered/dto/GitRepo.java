package com.github.taefi.shepherdui.endpoints.shephered.dto;

import java.io.Serializable;
import java.util.Objects;

public class GitRepo implements Serializable {

    private String url;
    private String branch;
    private String credentialsID;

    public GitRepo() {
    }

    public GitRepo(String url, String branch, String credentialsID) {
        this.url = url;
        this.branch = branch;
        this.credentialsID = credentialsID;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getCredentialsID() {
        return credentialsID;
    }

    public void setCredentialsID(String credentialsID) {
        this.credentialsID = credentialsID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GitRepo gitRepo = (GitRepo) o;
        return Objects.equals(getUrl(), gitRepo.getUrl()) && Objects.equals(getBranch(), gitRepo.getBranch()) && Objects.equals(getCredentialsID(), gitRepo.getCredentialsID());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUrl(), getBranch(), getCredentialsID());
    }
}
