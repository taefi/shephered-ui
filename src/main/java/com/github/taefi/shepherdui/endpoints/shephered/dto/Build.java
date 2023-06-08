package com.github.taefi.shepherdui.endpoints.shephered.dto;

import com.github.mvysny.shepherd.api.BuildResult;

import java.io.Serializable;
import java.time.Duration;
import java.time.Instant;
import java.util.Objects;

public class Build implements Serializable {

    private int number;
    private Duration duration;
    private Duration estimatedDuration;
    private Instant buildStarted;
    private BuildResult outcome;

    public Build() {
    }

    public Build(int number, Duration duration, Duration estimatedDuration, Instant buildStarted, BuildResult outcome) {
        this.number = number;
        this.duration = duration;
        this.estimatedDuration = estimatedDuration;
        this.buildStarted = buildStarted;
        this.outcome = outcome;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public Duration getEstimatedDuration() {
        return estimatedDuration;
    }

    public void setEstimatedDuration(Duration estimatedDuration) {
        this.estimatedDuration = estimatedDuration;
    }

    public Instant getBuildStarted() {
        return buildStarted;
    }

    public void setBuildStarted(Instant buildStarted) {
        this.buildStarted = buildStarted;
    }

    public BuildResult getOutcome() {
        return outcome;
    }

    public void setOutcome(BuildResult outcome) {
        this.outcome = outcome;
    }

    public boolean isCompleted() {
        return outcome != BuildResult.BUILDING;
    }

    public Instant getBuildEnded() {
        return isCompleted() ? buildStarted.plus(duration) : null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Build build = (Build) o;
        return getNumber() == build.getNumber() && Objects.equals(getDuration(), build.getDuration()) && Objects.equals(getEstimatedDuration(), build.getEstimatedDuration()) && Objects.equals(getBuildStarted(), build.getBuildStarted()) && getOutcome() == build.getOutcome();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumber(), getDuration(), getEstimatedDuration(), getBuildStarted(), getOutcome());
    }
}
