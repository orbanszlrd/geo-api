package com.orbanszlrd.geo.service;

import com.orbanszlrd.geo.country.Country;
import com.orbanszlrd.geo.country.CountryRepository;
import com.orbanszlrd.geo.poi.PoiType;
import com.orbanszlrd.geo.poi.PointOfInterest;
import com.orbanszlrd.geo.poi.PointOfInterestRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
@Log4j2
public class CountryImportService {
    private static String URL = "https://restcountries.com/v2/all";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private PointOfInterestRepository pointOfInterestRepository;

    private Country[] getAll() {
        ResponseEntity<Country[]> response = restTemplate.getForEntity(URL, Country[].class);

        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        } else {
            throw new RuntimeException("API Error");
        }
    }

    public void fillDatabase() {
        long countryCount = countryRepository.count();

        if (countryRepository.count() == 0) {
            Country[] countries = getAll();

            log.info("Import " + countries.length + " Countries");

            Arrays.stream(countries).forEach(country -> {
                log.info("Import " + country);

                try {
                    Country c = countryRepository.save(country);
                    log.info(c + " imported successfully");

                    if (c.getCapital() != null)  {
                        PointOfInterest pointOfInterest = pointOfInterestRepository.save(new PointOfInterest(c.getCapital(), PoiType.SETTLEMENT, c));
                        log.info(pointOfInterest + " imported successfully");
                    }
                } catch (Exception e) {
                    log.warn(e.getMessage());
                }
            });
        } else {
            log.info(countryCount + " countries already in the database.");
        }
    }
}
