package com.github.taefi.shepherdui.endpoints.shephered.mapper;

import com.github.taefi.shepherdui.endpoints.shephered.dto.Project;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ProjectMapperImpl implements BaseMapper.ProjectMapper {

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
    public Project toDto(com.github.mvysny.shepherd.api.Project e) {
        if ( e == null ) {
            return null;
        }

        Project project = new Project();
        //project.setId(e.);
        project.setDescription( e.getDescription() );
        project.setWebpage( e.getWebpage() );
        project.setGitRepo( gitRepoMapper.toDto( e.getGitRepo() ) );
        project.setProjectOwner(projectOwnerMapper.toDto(e.getOwner()));
        project.setProjectRuntime(projectRuntimeMapper.toDto(e.getRuntime()));
        project.setBuildSpec(buildSpecMapper.toDto(e.getBuild()));
        project.setPublication( publicationMapper.toDto( e.getPublication() ) );
        project.setAdditionalServices( e.getAdditionalServices().stream()
                .map(serviceMapper::toDto).collect(Collectors.toSet()) );

        return project;
    }

    @Override
    public com.github.mvysny.shepherd.api.Project toEntity(Project d) {
        return null;
    }
}
