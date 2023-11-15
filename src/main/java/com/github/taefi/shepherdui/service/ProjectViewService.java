package com.github.taefi.shepherdui.service;

import com.github.mvysny.shepherd.api.ShepherdClient;
import com.github.taefi.shepherdui.endpoints.shephered.ShepherdClientEndpoint;
import com.github.taefi.shepherdui.endpoints.shephered.dto.ProjectView;
import com.github.taefi.shepherdui.endpoints.shephered.mapper.KotlinMapper;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import dev.hilla.BrowserCallable;
import dev.hilla.Nonnull;
import dev.hilla.Nullable;
import dev.hilla.crud.ListService;
import dev.hilla.crud.filter.Filter;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.logging.Logger;

@AnonymousAllowed
@BrowserCallable
public class ProjectViewService implements ListService<ProjectView> {

    private static final Logger log = Logger.getLogger(ShepherdClientEndpoint.class.getName());

    private final ShepherdClient shepherdClient;

    private final KotlinMapper.ProjectViewMapper projectViewMapper;
    private final KotlinMapper.ProjectMapper projectMapper;


    public ProjectViewService(ShepherdClient shepherdClient, KotlinMapper.ProjectViewMapper projectViewMapper, KotlinMapper.ProjectMapper projectMapper) {
        this.shepherdClient = shepherdClient;
        this.projectViewMapper = projectViewMapper;
        this.projectMapper = projectMapper;
    }

    @Nonnull
    @Override
    public List<@Nonnull ProjectView> list(Pageable pageable, @Nullable Filter filter) {
        return shepherdClient.getAllProjects(null)
                .stream().map(projectViewMapper::toJava)
                .toList();
    }
}
