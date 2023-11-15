package com.github.taefi.shepherdui.endpoints.shephered.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.mvysny.shepherd.api.BuildResult;

import java.io.Serializable;
import java.time.Duration;
import java.time.Instant;
import java.util.Objects;

public class Build implements Serializable {

    private int number;
    private Long durationInSeconds;
    private Long estimatedDurationInSeconds;
    private Instant buildStarted;
    private BuildResult outcome;

    public Build() {
    }

    public Build(int number, Long durationInSeconds, Long estimatedDurationInSeconds, Instant buildStarted, BuildResult outcome) {
        this.number = number;
        this.durationInSeconds = durationInSeconds;
        this.estimatedDurationInSeconds = estimatedDurationInSeconds;
        this.buildStarted = buildStarted;
        this.outcome = outcome;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Long getDuration() {
        return durationInSeconds;
    }

    public void setDuration(Long durationInSeconds) {
        this.durationInSeconds = durationInSeconds;
    }

    public Long getEstimatedDuration() {
        return estimatedDurationInSeconds;
    }

    public void setEstimatedDuration(Long estimatedDurationInSeconds) {
        this.estimatedDurationInSeconds = estimatedDurationInSeconds;
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
        return isCompleted() ? buildStarted.plusSeconds(estimatedDurationInSeconds) : null;
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
