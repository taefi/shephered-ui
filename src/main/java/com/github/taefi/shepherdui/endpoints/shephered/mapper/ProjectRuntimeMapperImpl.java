package com.github.taefi.shepherdui.endpoints.shephered.mapper;

import com.github.taefi.shepherdui.endpoints.shephered.dto.ProjectRuntime;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;

@Component
public class ProjectRuntimeMapperImpl implements BaseMapper.ProjectRuntimeMapper {

    private final ResourcesMapper resourcesMapper;

    public ProjectRuntimeMapperImpl(ResourcesMapper resourcesMapper) {
        this.resourcesMapper = resourcesMapper;
    }

    @Override
    public ProjectRuntime toDto(com.github.mvysny.shepherd.api.ProjectRuntime e) {
        if ( e == null ) {
            return null;
        }

        return new ProjectRuntime(resourcesMapper.toDto(e.getResources()),
                e.getEnvVars());
    }

    @Override
    public com.github.mvysny.shepherd.api.ProjectRuntime toEntity(ProjectRuntime d) {
        return null;
    }
}
