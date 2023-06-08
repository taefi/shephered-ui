package com.github.taefi.shepherdui.endpoints.shephered.dto;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

public class Publication implements Serializable {

    private boolean publishOnMainDomain = true;
    private boolean https = true;
    private Set<String> additionalDomains = Set.of();

    public Publication() {
    }

    public Publication(boolean publishOnMainDomain, boolean https, Set<String> additionalDomains) {
        this.publishOnMainDomain = publishOnMainDomain;
        this.https = https;
        this.additionalDomains = additionalDomains;
    }

    public boolean isPublishOnMainDomain() {
        return publishOnMainDomain;
    }

    public void setPublishOnMainDomain(boolean publishOnMainDomain) {
        this.publishOnMainDomain = publishOnMainDomain;
    }

    public boolean isHttps() {
        return https;
    }

    public void setHttps(boolean https) {
        this.https = https;
    }

    public Set<String> getAdditionalDomains() {
        return additionalDomains;
    }

    public void setAdditionalDomains(Set<String> additionalDomains) {
        this.additionalDomains = additionalDomains;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publication that = (Publication) o;
        return isPublishOnMainDomain() == that.isPublishOnMainDomain() && isHttps() == that.isHttps() && Objects.equals(getAdditionalDomains(), that.getAdditionalDomains());
    }

    @Override
    public int hashCode() {
        return Objects.hash(isPublishOnMainDomain(), isHttps(), getAdditionalDomains());
    }
}
