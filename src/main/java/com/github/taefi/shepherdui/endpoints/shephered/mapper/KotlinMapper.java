package com.github.taefi.shepherdui.endpoints.shephered.mapper;

import com.github.taefi.shepherdui.endpoints.shephered.dto.*;



public interface KotlinMapper<DTO, ENTITY> {

    DTO toJava(ENTITY e);

    ENTITY toKotlin(DTO d);

    interface BuildMapper extends KotlinMapper<Build, com.github.mvysny.shepherd.api.Build> {}
    interface BuildSpecMapper extends KotlinMapper<BuildSpec, com.github.mvysny.shepherd.api.BuildSpec> {}
    interface GitRepoMapper extends KotlinMapper<GitRepo, com.github.mvysny.shepherd.api.GitRepo> {}
    interface ProjectMapper extends KotlinMapper<Project, com.github.mvysny.shepherd.api.Project> {}
    interface ProjectOwnerMapper extends KotlinMapper<ProjectOwner, com.github.mvysny.shepherd.api.ProjectOwner> {}
    interface ProjectRuntimeMapper extends KotlinMapper<ProjectRuntime, com.github.mvysny.shepherd.api.ProjectRuntime> {}
    interface ProjectViewMapper extends KotlinMapper<ProjectView, com.github.mvysny.shepherd.api.ProjectView> {}
    interface PublicationMapper extends KotlinMapper<Publication, com.github.mvysny.shepherd.api.Publication> {}
    interface ResourcesMapper extends KotlinMapper<Resources, com.github.mvysny.shepherd.api.Resources> {}
    interface ServiceMapper extends KotlinMapper<Service, com.github.mvysny.shepherd.api.Service> {}

}
