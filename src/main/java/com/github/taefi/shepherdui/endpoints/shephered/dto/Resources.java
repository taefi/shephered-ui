package com.github.taefi.shepherdui.endpoints.shephered.dto;

import java.io.Serializable;
import java.util.Objects;

public class Resources implements Serializable {

    private int memoryMb;
    private float cpu;

    public Resources() {
    }

    public Resources(int memoryMb, float cpu) {
        this.memoryMb = memoryMb;
        this.cpu = cpu;
    }

    public int getMemoryMb() {
        return memoryMb;
    }

    public void setMemoryMb(int memoryMb) {
        this.memoryMb = memoryMb;
    }

    public float getCpu() {
        return cpu;
    }

    public void setCpu(float cpu) {
        this.cpu = cpu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resources resources = (Resources) o;
        return getMemoryMb() == resources.getMemoryMb() && Float.compare(resources.getCpu(), getCpu()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMemoryMb(), getCpu());
    }
}
