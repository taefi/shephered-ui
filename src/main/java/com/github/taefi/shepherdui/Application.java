package com.github.taefi.shepherdui;

import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.theme.Theme;
import dev.hilla.sso.starter.SingleSignOnConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The entry point of the Spring Boot application.
 *
 * Use the @PWA annotation make the application installable on phones, tablets
 * and some desktop browsers.
 *
 */
@SpringBootApplication (scanBasePackages = {
        "com.github.taefi.shepherdui",
        "dev.hilla.sso.starter" // SSO Kit package.
})
@Theme(value = "shepherd-ui")
public class Application implements AppShellConfigurator {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
