package com.github.taefi.shepherdui.endpoints.shephered.mapper;

import com.github.taefi.shepherdui.endpoints.shephered.dto.Publication;
import org.springframework.stereotype.Component;

@Component
public class PublicationMapperImpl implements KotlinMapper.PublicationMapper {

    @Override
    public Publication toJava(com.github.mvysny.shepherd.api.Publication e) {
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
    public com.github.mvysny.shepherd.api.Publication toKotlin(Publication d) {
        if (d == null) {
            return null;
        }

        return new com.github.mvysny.shepherd.api.Publication(d.isPublishOnMainDomain(),
                d.isHttps(), d.getAdditionalDomains());
    }
}
