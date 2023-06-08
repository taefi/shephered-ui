package com.github.taefi.shepherdui.endpoints.shephered;

import com.github.mvysny.shepherd.api.ShepherdClient;
import com.github.taefi.shepherdui.endpoints.shephered.dto.Project;
import com.github.taefi.shepherdui.endpoints.shephered.dto.ProjectView;
import com.github.taefi.shepherdui.endpoints.shephered.mapper.BaseMapper;
import dev.hilla.Endpoint;
import dev.hilla.Nonnull;
import jakarta.annotation.security.PermitAll;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Endpoint
@PermitAll
public class ShepherdClientEndpoint {

    private static final Logger log = Logger.getLogger(ShepherdClientEndpoint.class.getName());

    private final ShepherdClient shepherdClient;

    private final BaseMapper.ProjectViewMapper projectViewMapper = Mappers.getMapper(BaseMapper.ProjectViewMapper.class);
    private final BaseMapper.ProjectMapper projectMapper = Mappers.getMapper(BaseMapper.ProjectMapper.class);

    public ShepherdClientEndpoint(ShepherdClient shepherdClient) {
        this.shepherdClient = shepherdClient;
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
