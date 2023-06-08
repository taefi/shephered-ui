package com.github.taefi.shepherdui.configuration;

import com.github.mvysny.shepherd.api.FakeShepherdClient;
import com.github.mvysny.shepherd.api.LinuxShepherdClient;
import com.github.mvysny.shepherd.api.ShepherdClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("prod")
@Configuration
public class ShepherdAdapterProdConfig {

    @Bean
    public ShepherdClient shepherdClient() {
        return new LinuxShepherdClient();
    }
}
