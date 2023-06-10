package com.github.taefi.shepherdui.endpoints.shephered.mapper;

import com.github.taefi.shepherdui.endpoints.shephered.dto.ProjectRuntime;
import org.springframework.stereotype.Component;

@Component
public class ProjectRuntimeMapperImpl implements KotlinMapper.ProjectRuntimeMapper {

    private final ResourcesMapper resourcesMapper;

    public ProjectRuntimeMapperImpl(ResourcesMapper resourcesMapper) {
        this.resourcesMapper = resourcesMapper;
    }

    @Override
    public ProjectRuntime toJava(com.github.mvysny.shepherd.api.ProjectRuntime e) {
        if ( e == null ) {
            return null;
        }

        return new ProjectRuntime(resourcesMapper.toJava(e.getResources()),
                e.getEnvVars());
    }

    @Override
    public com.github.mvysny.shepherd.api.ProjectRuntime toKotlin(ProjectRuntime d) {
        if (d == null) {
            return null;
        }
        return new com.github.mvysny.shepherd.api.ProjectRuntime(resourcesMapper.toKotlin(d.getResources()),
                d.getEnvVars());
    }
}
