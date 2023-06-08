package com.github.taefi.shepherdui.endpoints.shephered;

import com.github.mvysny.shepherd.api.ProjectView;
import com.github.mvysny.shepherd.api.ShepherdClient;
import dev.hilla.Endpoint;
import dev.hilla.Nonnull;
import jakarta.annotation.security.PermitAll;

import java.util.List;

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

}
