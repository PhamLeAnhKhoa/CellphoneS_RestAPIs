package com.hunganh.cellphones_restcontroller;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CellPhoneSRestcontrollerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CellPhoneSRestcontrollerApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        // create object and config
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper;
    }
}
