package com.github.taefi.shepherdui.endpoints.shephered.dto;

import com.github.mvysny.shepherd.api.ServiceType;

import java.io.Serializable;
import java.util.Objects;

public class Service implements Serializable {
    private ServiceType serviceType;

    public Service() {
    }

    public Service(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Service service = (Service) o;
        return getServiceType() == service.getServiceType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getServiceType());
    }
}
