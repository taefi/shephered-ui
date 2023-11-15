package com.github.taefi.shepherdui.service;

import com.github.mvysny.shepherd.api.ShepherdClient;
import com.github.taefi.shepherdui.endpoints.shephered.ShepherdClientEndpoint;
import com.github.taefi.shepherdui.endpoints.shephered.dto.Project;
import com.github.taefi.shepherdui.endpoints.shephered.dto.ProjectView;
import com.github.taefi.shepherdui.endpoints.shephered.mapper.KotlinMapper;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import dev.hilla.BrowserCallable;
import dev.hilla.Nonnull;
import dev.hilla.Nullable;
import dev.hilla.crud.CrudService;
import dev.hilla.crud.filter.Filter;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.logging.Logger;

@AnonymousAllowed
@BrowserCallable
public class ProjectService implements CrudService<Project, Long> {

    private static final Logger log = Logger.getLogger(ShepherdClientEndpoint.class.getName());

    private final ShepherdClient shepherdClient;

    private final KotlinMapper.ProjectMapper projectMapper;

    private final KotlinMapper.ProjectViewMapper projectViewMapper;


    public ProjectService(ShepherdClient shepherdClient, KotlinMapper.ProjectMapper projectMapper, KotlinMapper.ProjectViewMapper projectViewMapper) {
        this.shepherdClient = shepherdClient;
        this.projectMapper = projectMapper;
        this.projectViewMapper = projectViewMapper;
    }

    public @Nullable Project save(@Nonnull Project project) {
        log.info("Creating project...");
        project.setId("test-" + System.currentTimeMillis());
        shepherdClient.createProject(projectMapper.toKotlin(project));
        log.info("Project created!");
        return project;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Project get(Long id) {
        return null;
    }

    @Nonnull
    @Override
    public List<@Nonnull Project> list(Pageable pageable, @Nullable Filter filter) {
        return shepherdClient.getAllProjects(null)
                .stream().map(projectViewMapper::toJava)
                .map(ProjectView::getProject)
                .toList();
    }
}
