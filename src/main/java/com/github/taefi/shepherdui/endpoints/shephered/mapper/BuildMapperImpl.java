package com.github.taefi.shepherdui.endpoints.shephered.mapper;

import com.github.taefi.shepherdui.endpoints.shephered.dto.Build;
import org.springframework.stereotype.Component;

@Component
public class BuildMapperImpl implements BaseMapper.BuildMapper {

    @Override
    public Build toDto(com.github.mvysny.shepherd.api.Build e) {
        if ( e == null ) {
            return null;
        }

        Build build = new Build();

        build.setNumber( e.getNumber() );
        build.setDuration( e.getDuration() );
        build.setEstimatedDuration( e.getEstimatedDuration() );
        build.setBuildStarted( e.getBuildStarted() );
        build.setOutcome( e.getOutcome() );

        return build;
    }

    @Override
    public com.github.mvysny.shepherd.api.Build toEntity(Build d) {
        return null;
    }
}
