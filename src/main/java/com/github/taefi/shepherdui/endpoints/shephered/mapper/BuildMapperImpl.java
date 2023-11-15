package com.github.taefi.shepherdui.endpoints.shephered.mapper;

import com.github.taefi.shepherdui.endpoints.shephered.dto.Build;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.Optional;

@Component
public class BuildMapperImpl implements KotlinMapper.BuildMapper {

    @Override
    public Build toJava(com.github.mvysny.shepherd.api.Build b) {
        if ( b == null ) {
            return null;
        }

        Build build = new Build();

        build.setNumber( b.getNumber() );
        build.setDuration( b.getDuration().getSeconds() );
        build.setEstimatedDuration( b.getEstimatedDuration().getSeconds() );
        build.setBuildStarted( b.getBuildStarted() );
        build.setOutcome( b.getOutcome() );

        return build;
    }

    @Override
    public com.github.mvysny.shepherd.api.Build toKotlin(Build d) {
        return null;
    }
}
