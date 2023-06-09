package com.github.taefi.shepherdui.endpoints.shephered.mapper;

import com.github.taefi.shepherdui.endpoints.shephered.dto.Publication;
import org.springframework.stereotype.Component;

@Component
public class PublicationMapperImpl implements BaseMapper.PublicationMapper {

    @Override
    public Publication toDto(com.github.mvysny.shepherd.api.Publication e) {
        if ( e == null ) {
            return null;
        }

        Publication publication = new Publication();

        publication.setPublishOnMainDomain( e.getPublishOnMainDomain() );
        publication.setHttps( e.getHttps() );
        publication.setAdditionalDomains( e.getAdditionalDomains() );

        return publication;
    }

    @Override
    public com.github.mvysny.shepherd.api.Publication toEntity(Publication d) {
        return null;
    }
}
