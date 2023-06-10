package com.github.taefi.shepherdui.endpoints.shephered.mapper;

import com.github.taefi.shepherdui.endpoints.shephered.dto.BuildSpec;
import org.springframework.stereotype.Component;


@Component
public class BuildSpecMapperImpl implements KotlinMapper.BuildSpecMapper {

    private final ResourcesMapper resourcesMapper;

    public BuildSpecMapperImpl(ResourcesMapper resourcesMapper) {
        this.resourcesMapper = resourcesMapper;
    }

    @Override
    public BuildSpec toJava(com.github.mvysny.shepherd.api.BuildSpec e) {
        if ( e == null ) {
            return null;
        }

        return new BuildSpec(resourcesMapper.toJava(e.getResources()),
                e.getBuildArgs(), e.getDockerFile());
    }

    @Override
    public com.github.mvysny.shepherd.api.BuildSpec toKotlin(BuildSpec d) {
        if (d == null) {
            return null;
        }
        return new com.github.mvysny.shepherd.api.BuildSpec(resourcesMapper.toKotlin(d.getResources()),
                d.getBuildArgs(), d.getDockerFile());
    }
}
