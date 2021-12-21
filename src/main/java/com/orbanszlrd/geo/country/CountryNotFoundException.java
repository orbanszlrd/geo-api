package com.orbanszlrd.geo.country;

public class CountryNotFoundException extends RuntimeException {
    public CountryNotFoundException(Long id) {
        super(String.format("Country '%s' not found!", id));
    }
}