package com.github.taefi.shepherdui.configuration.security;

import dev.hilla.sso.starter.*;
import dev.hilla.sso.starter.endpoint.BackChannelLogoutEndpoint;
import dev.hilla.sso.starter.endpoint.SingleSignOnEndpoint;
import dev.hilla.sso.starter.endpoint.UserEndpoint;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;

@Configuration
@EnableAutoConfiguration(exclude={SingleSignOnConfiguration.class})
@EnableWebSecurity
public class GoogleSingleSignOnConfiguration {

    private final BackChannelLogoutSubscription backChannelLogoutSubscription;


    private final BootstrapDataServiceListener bootstrapDataServiceListener;

    private final BackChannelLogoutEndpoint backChannelLogoutEndpoint;

    private final SingleSignOnEndpoint singleSignOnEndpoint;

    private final UserEndpoint userEndpoint;

    /**
     * Creates an instance of this configuration bean.
     *
     * @param clientRegistrationRepository
     *            the client-registration repository
     */
    public GoogleSingleSignOnConfiguration(
                                     ClientRegistrationRepository clientRegistrationRepository) {

        this.backChannelLogoutSubscription = new BackChannelLogoutSubscription();
        this.ssoContext = new GoogleSingleSingOnContext(
                clientRegistrationRepository, new SingleSignOnProperties(),
                backChannelLogoutSubscription);
        this.bootstrapDataServiceListener = new BootstrapDataServiceListener(
                ssoContext);
        this.backChannelLogoutEndpoint = new BackChannelLogoutEndpoint(
                ssoContext);
        this.singleSignOnEndpoint = new SingleSignOnEndpoint(
                ssoContext);
        this.userEndpoint = new UserEndpoint();
    }

    @Bean
    public BackChannelLogoutSubscription backChannelLogoutSubscription() {
        return backChannelLogoutSubscription;
    }

    @Bean
    public BootstrapDataServiceListener bootstrapDataServiceListener() {
        return bootstrapDataServiceListener;
    }

    @Bean
    public BackChannelLogoutEndpoint backChannelLogoutEndpoint() {
        return backChannelLogoutEndpoint;
    }

    @Bean
    public SingleSignOnEndpoint singleSignOnEndpoint() {
        return singleSignOnEndpoint;
    }

    @Bean
    public UserEndpoint userEndpoint() {
        return userEndpoint;
    }



    private final SingleSignOnContext ssoContext;


    @Bean
    public SingleSignOnContext singleSignOnContext() {
        return ssoContext;
    }
}
