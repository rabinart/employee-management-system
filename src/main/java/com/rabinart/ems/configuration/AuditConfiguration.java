package com.rabinart.ems.configuration;

import com.rabinart.ems.EmsApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.envers.repository.config.EnableEnversRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

@Configuration
@EnableJpaAuditing
@EnableEnversRepositories(basePackageClasses = EmsApplication.class)
public class AuditConfiguration {

    @Bean
    public AuditorAware<String> auditorAware(){
        return () -> Optional.of("Rabinart");
    }
}
