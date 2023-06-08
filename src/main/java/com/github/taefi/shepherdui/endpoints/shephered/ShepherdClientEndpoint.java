package com.github.taefi.shepherdui.endpoints.shephered;

import com.github.mvysny.shepherd.api.ShepherdClient;
import com.github.taefi.shepherdui.endpoints.shephered.dto.ProjectView;
import com.github.taefi.shepherdui.endpoints.shephered.mapper.BaseMapper;
import dev.hilla.Endpoint;
import dev.hilla.Nonnull;
import jakarta.annotation.security.PermitAll;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Endpoint
@PermitAll
public class ShepherdClientEndpoint {

    private final ShepherdClient shepherdClient;

    private final BaseMapper.ProjectViewMapper projectViewMapper = Mappers.getMapper(BaseMapper.ProjectViewMapper.class);

    public ShepherdClientEndpoint(ShepherdClient shepherdClient) {
        this.shepherdClient = shepherdClient;
    }

    @Nonnull
    public List<ProjectView> getProjects(String ownerEmail) {
        return shepherdClient.getAllProjects(null)
                .stream().map(projectViewMapper::toDto)
                .toList();
    }

}
