package com.github.taefi.shepherdui.endpoints.shephered;

import com.github.mvysny.shepherd.api.ShepherdClient;
import com.github.taefi.shepherdui.endpoints.shephered.dto.Project;
import com.github.taefi.shepherdui.endpoints.shephered.dto.ProjectView;
import com.github.taefi.shepherdui.endpoints.shephered.mapper.BaseMapper;
import dev.hilla.Endpoint;
import dev.hilla.Nonnull;
import jakarta.annotation.security.PermitAll;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Endpoint
@PermitAll
public class ShepherdClientEndpoint {

    private static final Logger log = Logger.getLogger(ShepherdClientEndpoint.class.getName());

    private final ShepherdClient shepherdClient;

    private final BaseMapper.ProjectViewMapper projectViewMapper;
    private final BaseMapper.ProjectMapper projectMapper;

    public ShepherdClientEndpoint(ShepherdClient shepherdClient, BaseMapper.ProjectViewMapper projectViewMapper, BaseMapper.ProjectMapper projectMapper) {
        this.shepherdClient = shepherdClient;
        this.projectViewMapper = projectViewMapper;
        this.projectMapper = projectMapper;
    }

    @Nonnull
    public List<@Nonnull ProjectView> getProjects(String ownerEmail) {
        return shepherdClient.getAllProjects(null)
                .stream().map(projectViewMapper::toDto)
                .toList();
    }

    public void createProject(@Nonnull Project project) {
        log.info("Creating a project: %s".formatted(project));
//        shepherdClient.createProject(projectMapper.);
    }

}
