package com.github.taefi.shepherdui.endpoints.shephered.mapper;

import com.github.taefi.shepherdui.endpoints.shephered.dto.ProjectView;
import org.springframework.stereotype.Component;

@Component
public class ProjectViewMapperImpl implements KotlinMapper.ProjectViewMapper {

    private final ProjectMapper projectMapper;
    private final BuildMapper buildMapper;

    public ProjectViewMapperImpl(ProjectMapper projectMapper, BuildMapper buildMapper) {
        this.projectMapper = projectMapper;
        this.buildMapper = buildMapper;
    }

    @Override
    public ProjectView toJava(com.github.mvysny.shepherd.api.ProjectView e) {
        if ( e == null ) {
            return null;
        }

        ProjectView projectView = new ProjectView();

        projectView.setProject( projectMapper.toJava( e.getProject() ) );
        projectView.setLastBuild( buildMapper.toJava( e.getLastBuild() ) );

        return projectView;
    }

    @Override
    public com.github.mvysny.shepherd.api.ProjectView toKotlin(ProjectView d) {
        return null;
    }
}
