package com.hunganh.cellphones_restcontroller.config;

import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FlywayConfig {
    @Bean
    public FlywayMigrationStrategy FlywayMigrationStrategyClean(){
        return flyway -> {
            flyway.clean();
            flyway.migrate();
        };
    }
}
