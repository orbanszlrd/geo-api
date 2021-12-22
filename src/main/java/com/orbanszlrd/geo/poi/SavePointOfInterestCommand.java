package com.orbanszlrd.geo.poi;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SavePointOfInterestCommand {
    @NotBlank
    @Size(min = 2, max = 100)
    @Schema(description = "The name of the poi", example = "Budapest", required = true)
    private String name;

    @Schema(description = "The type of the POI", example = "SETTLEMENT", required = true)
    private PoiType type;

    @NotNull
    @Schema(description = "The id of the country", example = "102", required = true)
    private Long countryId;

    @Schema(description = "The latitude of the poi", example = "47.497913", required = true)
    private Float latitude;

    @Schema(description = "The longitude of the poi", example = "19.040236", required = true)
    private Float longitude;

    @Schema(description = "The altitude of the poi", example = "96", required = true)
    private Float altitude;
}
