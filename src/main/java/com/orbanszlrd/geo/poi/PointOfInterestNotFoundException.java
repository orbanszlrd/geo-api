package com.orbanszlrd.geo.poi;

public class PointOfInterestNotFoundException extends RuntimeException {
    public PointOfInterestNotFoundException(Long id) {
        super(String.format("Poi '%s' not found!", id));
    }
}
