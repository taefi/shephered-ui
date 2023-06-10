package com.github.taefi.shepherdui.endpoints.shephered.mapper;

import com.github.taefi.shepherdui.endpoints.shephered.dto.ProjectOwner;
import org.springframework.stereotype.Component;

@Component
public class ProjectOwnerMapperImpl implements KotlinMapper.ProjectOwnerMapper {

    @Override
    public ProjectOwner toJava(com.github.mvysny.shepherd.api.ProjectOwner e) {
        if ( e == null ) {
            return null;
        }

        return new ProjectOwner(e.getName(), e.getEmail());
    }

    @Override
    public com.github.mvysny.shepherd.api.ProjectOwner toKotlin(ProjectOwner d) {
        if (d == null) {
            return null;
        }

        return new com.github.mvysny.shepherd.api.ProjectOwner(d.getName(), d.getEmail());
    }
}
