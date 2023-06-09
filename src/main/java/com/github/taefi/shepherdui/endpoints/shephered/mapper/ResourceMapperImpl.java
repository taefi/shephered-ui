package com.github.taefi.shepherdui.endpoints.shephered.mapper;

import com.github.taefi.shepherdui.endpoints.shephered.dto.Resources;
import org.springframework.stereotype.Component;

@Component
public class ResourceMapperImpl implements BaseMapper.ResourcesMapper {

    @Override
    public Resources toDto(com.github.mvysny.shepherd.api.Resources e) {
        if ( e == null ) {
            return null;
        }

        return new Resources(e.getMemoryMb(), e.getCpu());
    }

    @Override
    public com.github.mvysny.shepherd.api.Resources toEntity(Resources d) {
        return null;
    }
}
