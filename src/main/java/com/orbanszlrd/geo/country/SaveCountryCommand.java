package com.orbanszlrd.geo.country;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaveCountryCommand {
    @NotBlank
    @Size(min = 2, max = 100)
    @Schema(description = "The name of the country", example = "Hungary", required = true)
    private String name;

    @Size(min = 2, max = 2)
    @Schema(description = "The Alpha 2 Code of the country", example = "HU")
    private String alpha2Code;

    @Size(min = 3, max = 3)
    @Schema(description = "The Alpha 3 Code of the country", example = "HUN")
    private String alpha3Code;

    @Schema(description = "The capital city of the country", example = "Budapest")
    private String capital;

    @Schema(description = "The subregion of the country", example = "Central Europe")
    private String subregion;

    @Schema(description = "The region of the country", example = "Europe")
    private String region;

    @Schema(description = "The population of the country", example = "9749763")
    private Long population;

    @Schema(description = "The area of the country", example = "93028.0")
    private Float area;

    @Schema(description = "The flag of the country", example = "https://flagcdn.com/hu.svg")
    private String flag;
}
