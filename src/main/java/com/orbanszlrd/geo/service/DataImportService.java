package com.orbanszlrd.geo.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class DataImportService {
    @Autowired
    CountryImportService countryImportService;

    @Bean
    public CommandLineRunner importCountries() {
        return args -> {
            log.info("Fill the database with all countries");
            countryImportService.fillDatabase();
        };
    }

}
