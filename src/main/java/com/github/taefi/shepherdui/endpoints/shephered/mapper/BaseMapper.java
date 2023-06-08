package com.github.taefi.shepherdui.endpoints.shephered.mapper;

import com.github.taefi.shepherdui.endpoints.shephered.dto.*;
import org.mapstruct.Mapper;

@Mapper
public interface BaseMapper<DTO, ENTITY> {

    DTO toDto(ENTITY e);

    ENTITY toEntity(DTO d);


    interface BuildMapper extends BaseMapper<Build, com.github.mvysny.shepherd.api.Build> {}

    interface BuildSpecMapper extends BaseMapper<BuildSpec, com.github.mvysny.shepherd.api.BuildSpec> {}

    interface GitRepoMapper extends BaseMapper<GitRepo, com.github.mvysny.shepherd.api.GitRepo> {}

    interface ProjectMapper extends BaseMapper<Project, com.github.mvysny.shepherd.api.Project> {}

    interface ProjectIdMapper extends BaseMapper<ProjectId, com.github.mvysny.shepherd.api.ProjectId> {}

    interface ProjectOwnerMapper extends BaseMapper<ProjectOwner, com.github.mvysny.shepherd.api.ProjectOwner> {}

    interface ProjectRuntimeMapper extends BaseMapper<ProjectRuntime, com.github.mvysny.shepherd.api.ProjectRuntime> {}

    interface ProjectViewMapper extends BaseMapper<ProjectView, com.github.mvysny.shepherd.api.ProjectView> {}

    interface PublicationMapper extends BaseMapper<Publication, com.github.mvysny.shepherd.api.Publication> {}

    interface ResourcesMapper extends BaseMapper<Resources, com.github.mvysny.shepherd.api.Resources> {}

    interface ServiceMapper extends BaseMapper<Service, com.github.mvysny.shepherd.api.Service> {}

}
