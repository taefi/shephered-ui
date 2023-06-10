package com.github.taefi.shepherdui.endpoints.shephered;

import com.github.mvysny.shepherd.api.ShepherdClient;
import com.github.taefi.shepherdui.endpoints.shephered.dto.Project;
import com.github.taefi.shepherdui.endpoints.shephered.dto.ProjectView;
import com.github.taefi.shepherdui.endpoints.shephered.mapper.KotlinMapper;
import dev.hilla.Endpoint;
import dev.hilla.Nonnull;
import jakarta.annotation.security.PermitAll;

import java.util.List;
import java.util.logging.Logger;

@Endpoint
@PermitAll
public class ShepherdClientEndpoint {

    private static final Logger log = Logger.getLogger(ShepherdClientEndpoint.class.getName());

    private final ShepherdClient shepherdClient;

    private final KotlinMapper.ProjectViewMapper projectViewMapper;
    private final KotlinMapper.ProjectMapper projectMapper;

    public ShepherdClientEndpoint(ShepherdClient shepherdClient, KotlinMapper.ProjectViewMapper projectViewMapper, KotlinMapper.ProjectMapper projectMapper) {
        this.shepherdClient = shepherdClient;
        this.projectViewMapper = projectViewMapper;
        this.projectMapper = projectMapper;
    }

    @Nonnull
    public List<@Nonnull ProjectView> getProjects(String ownerEmail) {
        return shepherdClient.getAllProjects(null)
                .stream().map(projectViewMapper::toJava)
                .toList();
    }

    public void createProject(@Nonnull Project project) {
        log.info("Creating project...");
        project.setId("test-" + System.currentTimeMillis());
        shepherdClient.createProject(projectMapper.toKotlin(project));
        log.info("Project created!");
    }

}
