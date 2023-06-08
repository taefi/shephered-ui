package com.github.taefi.shepherdui.configuration;

import com.github.mvysny.shepherd.api.FakeShepherdClient;
import com.github.mvysny.shepherd.api.ShepherdClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("dev")
@Configuration
public class ShepherdAdapterDevConfig {

    private final static ShepherdClient FAKE = new FakeShepherdClient().withFakeProject();
    @Bean
    public ShepherdClient shepherdClient() {
        return FAKE;
    }
}
