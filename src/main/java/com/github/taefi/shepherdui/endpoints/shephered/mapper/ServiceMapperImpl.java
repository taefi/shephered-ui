package com.github.taefi.shepherdui.endpoints.shephered.mapper;

import com.github.taefi.shepherdui.endpoints.shephered.dto.Service;
import org.springframework.stereotype.Component;

@Component
public class ServiceMapperImpl implements BaseMapper.ServiceMapper {

    @Override
    public Service toDto(com.github.mvysny.shepherd.api.Service e) {
        if ( e == null ) {
            return null;
        }

        return new Service(e.getType());
    }

    @Override
    public com.github.mvysny.shepherd.api.Service toEntity(Service d) {
        return null;
    }
}
