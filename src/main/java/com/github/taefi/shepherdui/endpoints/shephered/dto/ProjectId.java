package com.github.taefi.shepherdui.endpoints.shephered.dto;

import java.io.Serializable;
import java.util.Objects;

public class ProjectId implements Serializable {

    private String id;


    public ProjectId() {
    }

    public ProjectId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectId projectId = (ProjectId) o;
        return Objects.equals(getId(), projectId.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
