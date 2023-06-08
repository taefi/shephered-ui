package com.github.taefi.shepherdui.endpoints.shephered;

import com.github.mvysny.shepherd.api.ProjectView;
import com.github.mvysny.shepherd.api.ShepherdClient;
import dev.hilla.Endpoint;
import dev.hilla.Nonnull;
import jakarta.annotation.security.PermitAll;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Endpoint
@PermitAll
public class ShepherdClientEndpoint {

    private final ShepherdClient shepherdClient;

    public ShepherdClientEndpoint(ShepherdClient shepherdClient) {
        this.shepherdClient = shepherdClient;
    }

    @Nonnull
    public List<ProjectView> getProjects(String ownerEmail) {
        return shepherdClient.getAllProjects(null);
    }

    @Nonnull
    public List<@Nonnull Data> getData() {
        return IntStream.range(0, 100).mapToObj(i -> new Data("name %d".formatted(i), "org %d".formatted(i))).collect(Collectors.toList());
    }

    public record Data(
            String name,
            String org
    ) {
    }
}
