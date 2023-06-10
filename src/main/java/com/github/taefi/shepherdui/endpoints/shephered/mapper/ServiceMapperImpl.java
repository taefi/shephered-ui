package com.github.taefi.shepherdui.endpoints.shephered.mapper;

import com.github.taefi.shepherdui.endpoints.shephered.dto.Service;
import org.springframework.stereotype.Component;

@Component
public class ServiceMapperImpl implements KotlinMapper.ServiceMapper {

    @Override
    public Service toJava(com.github.mvysny.shepherd.api.Service e) {
        if ( e == null ) {
            return null;
        }

        return new Service(e.getType());
    }

    @Override
    public com.github.mvysny.shepherd.api.Service toKotlin(Service d) {
        if (d == null) {
            return null;
        }

        return new com.github.mvysny.shepherd.api.Service(d.getServiceType());
    }
}
