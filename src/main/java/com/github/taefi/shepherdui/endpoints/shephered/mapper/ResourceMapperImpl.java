package com.github.taefi.shepherdui.endpoints.shephered.mapper;

import com.github.taefi.shepherdui.endpoints.shephered.dto.Resources;
import org.springframework.stereotype.Component;

@Component
public class ResourceMapperImpl implements KotlinMapper.ResourcesMapper {

    @Override
    public Resources toJava(com.github.mvysny.shepherd.api.Resources e) {
        if ( e == null ) {
            return null;
        }

        return new Resources(e.getMemoryMb(), e.getCpu());
    }

    @Override
    public com.github.mvysny.shepherd.api.Resources toKotlin(Resources d) {
        if (d == null) {
            return null;
        }

        return new com.github.mvysny.shepherd.api.Resources(d.getMemoryMb(), d.getCpu());
    }
}
