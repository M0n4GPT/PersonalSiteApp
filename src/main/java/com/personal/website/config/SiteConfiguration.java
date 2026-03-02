package com.personal.website.config;

import com.personal.website.model.Experience;
import com.personal.website.model.Project;
import com.personal.website.model.Skill;
import com.personal.website.model.SiteConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Loads all site.* properties from application.yml into a SiteConfig bean.
 */
@Configuration
public class SiteConfiguration {

    @Bean
    @ConfigurationProperties(prefix = "site")
    public SiteConfig siteConfig() {
        return new SiteConfig();
    }
}
