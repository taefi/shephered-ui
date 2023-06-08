package com.github.taefi.shepherdui.endpoints.shephered.mapper;

import com.github.taefi.shepherdui.endpoints.shephered.dto.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


public interface BaseMapper<DTO, ENTITY> {

    DTO toDto(ENTITY e);

//    ENTITY to2Entity(DTO d);

    @Mapper
    interface BuildMapper extends BaseMapper<Build, com.github.mvysny.shepherd.api.Build> {}
    @Mapper
    interface BuildSpecMapper extends BaseMapper<BuildSpec, com.github.mvysny.shepherd.api.BuildSpec> {}
    @Mapper
    interface GitRepoMapper extends BaseMapper<GitRepo, com.github.mvysny.shepherd.api.GitRepo> {}
    @Mapper
    interface ProjectMapper extends BaseMapper<Project, com.github.mvysny.shepherd.api.Project> {}
    @Mapper
    interface ProjectIdMapper extends BaseMapper<ProjectId, com.github.mvysny.shepherd.api.ProjectId> {}
    @Mapper
    interface ProjectOwnerMapper extends BaseMapper<ProjectOwner, com.github.mvysny.shepherd.api.ProjectOwner> {}
    @Mapper
    interface ProjectRuntimeMapper extends BaseMapper<ProjectRuntime, com.github.mvysny.shepherd.api.ProjectRuntime> {}
    @Mapper
    interface ProjectViewMapper extends BaseMapper<ProjectView, com.github.mvysny.shepherd.api.ProjectView> {}
    @Mapper
    interface PublicationMapper extends BaseMapper<Publication, com.github.mvysny.shepherd.api.Publication> {}
    @Mapper
    interface ResourcesMapper extends BaseMapper<Resources, com.github.mvysny.shepherd.api.Resources> {}
    @Mapper
    interface ServiceMapper extends BaseMapper<Service, com.github.mvysny.shepherd.api.Service> {}

}
