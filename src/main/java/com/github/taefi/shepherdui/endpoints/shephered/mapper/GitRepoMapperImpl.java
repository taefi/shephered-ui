package com.github.taefi.shepherdui.endpoints.shephered.mapper;

import com.github.taefi.shepherdui.endpoints.shephered.dto.GitRepo;
import org.springframework.stereotype.Component;

@Component
public class GitRepoMapperImpl implements KotlinMapper.GitRepoMapper {
    @Override
    public GitRepo toJava(com.github.mvysny.shepherd.api.GitRepo e) {
        if ( e == null ) {
            return null;
        }

        GitRepo gitRepo = new GitRepo();

        gitRepo.setUrl( e.getUrl() );
        gitRepo.setBranch( e.getBranch() );
        gitRepo.setCredentialsID( e.getCredentialsID() );

        return gitRepo;
    }

    @Override
    public com.github.mvysny.shepherd.api.GitRepo toKotlin(GitRepo d) {
        if (d == null) {
            return null;
        }
        return new com.github.mvysny.shepherd.api.GitRepo(d.getUrl(),
                d.getBranch(), d.getCredentialsID());
    }
}
