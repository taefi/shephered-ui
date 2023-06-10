package com.github.taefi.shepherdui.endpoints.shephered.mapper;

import com.github.mvysny.shepherd.api.ProjectId;
import com.github.taefi.shepherdui.endpoints.shephered.dto.Project;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ProjectMapperImpl implements KotlinMapper.ProjectMapper {

    private final GitRepoMapper gitRepoMapper;
    private final PublicationMapper publicationMapper;
    private final ServiceMapper serviceMapper;
    private final ProjectOwnerMapper projectOwnerMapper;
    private final ProjectRuntimeMapper projectRuntimeMapper;
    private final BuildSpecMapper buildSpecMapper;

    public ProjectMapperImpl(GitRepoMapper gitRepoMapper,
                             PublicationMapper publicationMapper,
                             ServiceMapper serviceMapper,
                             ProjectOwnerMapper projectOwnerMapper,
                             ProjectRuntimeMapper projectRuntimeMapper,
                             BuildSpecMapper buildSpecMapper) {
        this.gitRepoMapper = gitRepoMapper;
        this.publicationMapper = publicationMapper;
        this.serviceMapper = serviceMapper;
        this.projectOwnerMapper = projectOwnerMapper;
        this.projectRuntimeMapper = projectRuntimeMapper;
        this.buildSpecMapper = buildSpecMapper;
    }

    @Override
    public Project toJava(com.github.mvysny.shepherd.api.Project e) {
        if ( e == null ) {
            return null;
        }

        Project project = new Project();
        project.setId(e.getId().getId());
        project.setDescription( e.getDescription() );
        project.setWebpage( e.getWebpage() );
        project.setGitRepo( gitRepoMapper.toJava( e.getGitRepo() ) );
        project.setProjectOwner(projectOwnerMapper.toJava(e.getOwner()));
        project.setProjectRuntime(projectRuntimeMapper.toJava(e.getRuntime()));
        project.setBuildSpec(buildSpecMapper.toJava(e.getBuild()));
        project.setPublication( publicationMapper.toJava( e.getPublication() ) );
        project.setAdditionalServices( e.getAdditionalServices().stream()
                .map(serviceMapper::toJava)
                .collect(Collectors.toSet()) );

        return project;
    }

    @Override
    public com.github.mvysny.shepherd.api.Project toKotlin(Project d) {
        if (d == null) {
            return null;
        }

        return new com.github.mvysny.shepherd.api.Project(
                new ProjectId(d.getId()),
                d.getDescription(),
                d.getWebpage(),
                gitRepoMapper.toKotlin(d.getGitRepo()),
                projectOwnerMapper.toKotlin(d.getProjectOwner()),
                projectRuntimeMapper.toKotlin(d.getProjectRuntime()),
                buildSpecMapper.toKotlin(d.getBuildSpec()),
                publicationMapper.toKotlin(d.getPublication()),
                d.getAdditionalServices().stream()
                        .map(serviceMapper::toKotlin)
                        .collect(Collectors.toSet())
        );
    }
}
