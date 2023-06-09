package com.github.taefi.shepherdui.endpoints.shephered.mapper;

import com.github.taefi.shepherdui.endpoints.shephered.dto.ProjectId;
import org.springframework.stereotype.Component;

@Component
public class ProjectIdMapperImpl implements BaseMapper.ProjectIdMapper {

    @Override
    public ProjectId toDto(com.github.mvysny.shepherd.api.ProjectId e) {
        if ( e == null ) {
            return null;
        }

        return new ProjectId(e.getId());
    }

    @Override
    public com.github.mvysny.shepherd.api.ProjectId toEntity(ProjectId d) {
        return null;
    }
}
