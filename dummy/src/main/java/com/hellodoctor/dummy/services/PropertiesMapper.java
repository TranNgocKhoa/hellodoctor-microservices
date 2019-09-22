package com.hellodoctor.dummy.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.AbstractEnvironment;
import org.springframework.core.env.EnumerablePropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MutablePropertySources;

import java.util.Arrays;
import java.util.stream.StreamSupport;

@Configuration
@Slf4j
@PropertySource({"classpath:application-${spring.profiles.active}.yml"})
public class PropertiesMapper {

    private final Environment environment;

    public PropertiesMapper(Environment environment) {
        this.environment = environment;
    }

    public void readProperty() {
        final MutablePropertySources sources = ((AbstractEnvironment) environment).getPropertySources();
        StreamSupport.stream(sources.spliterator(), false)
                .filter(ps -> ps instanceof EnumerablePropertySource)
                .map(ps -> ((EnumerablePropertySource) ps).getPropertyNames())
                .flatMap(Arrays::stream)
                .forEach(prop -> log.info("{}: {}", prop, environment.getProperty(prop)));
        log.info("===========================================");
    }
}
