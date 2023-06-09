package com.github.taefi.shepherdui.endpoints.shephered.mapper;

import com.github.taefi.shepherdui.endpoints.shephered.dto.BuildSpec;
import org.springframework.stereotype.Component;


@Component
public class BuildSpecMapperImpl implements BaseMapper.BuildSpecMapper {

    private final ResourcesMapper resourcesMapper;

    public BuildSpecMapperImpl(ResourcesMapper resourcesMapper) {
        this.resourcesMapper = resourcesMapper;
    }

    @Override
    public BuildSpec toDto(com.github.mvysny.shepherd.api.BuildSpec e) {
        if ( e == null ) {
            return null;
        }

        return new BuildSpec(resourcesMapper.toDto(e.getResources()),
                e.getBuildArgs(), e.getDockerFile());
    }

    @Override
    public com.github.mvysny.shepherd.api.BuildSpec toEntity(BuildSpec d) {
        return null;
    }
}
