package com.orbanszlrd.geo.poi;

import lombok.Data;

@Data
public class PointOfInterestDto {
    private Long id;
    private String name;
    private PoiType type;
    private String countryName;
    private Float latitude;
    private Float longitude;
    private Float altitude;
}
