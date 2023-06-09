package com.github.taefi.shepherdui.endpoints.shephered.mapper;

import com.github.taefi.shepherdui.endpoints.shephered.dto.ProjectOwner;
import org.springframework.stereotype.Component;

@Component
public class ProjectOwnerMapperImpl implements BaseMapper.ProjectOwnerMapper {

    @Override
    public ProjectOwner toDto(com.github.mvysny.shepherd.api.ProjectOwner e) {
        if ( e == null ) {
            return null;
        }

        return new ProjectOwner(e.getName(), e.getEmail());
    }

    @Override
    public com.github.mvysny.shepherd.api.ProjectOwner toEntity(ProjectOwner d) {
        return null;
    }
}
