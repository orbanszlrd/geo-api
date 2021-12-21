package com.orbanszlrd.geo.country;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "The id of the country", example = "1", required = true, minimum = "1", maximum = "1000")
    private Long id;

    @NotBlank
    @Size(min = 2, max = 100)
    @Schema(description = "The name of the country", example = "Hungary", required = true)
    @Column(unique = true, nullable = false, length = 100)
    private String name;

    @Size(min = 2, max = 2)
    @Schema(description = "The Alpha 2 Code of the country", example = "HU")
    @Column(unique = true, nullable = false, length = 2)
    private String alpha2Code;

    @Size(min = 3, max = 3)
    @Schema(description = "The Alpha 3 Code of the country", example = "HU")
    @Column(unique = true, nullable = false, length = 3)
    private String alpha3Code;

    @Column(length = 100)
    @Schema(description = "The capital city of the country", example = "Budapest")
    private String capital;

    @Column(nullable = false, length = 100)
    @Schema(description = "The subregion of the country", example = "Central Europe")
    private String subregion;

    @Column(nullable = false, length = 100)
    @Schema(description = "The region of the country", example = "Europe")
    private String region;

    @Schema(description = "The population of the country", example = "9749763")
    private Long population;

    @Schema(description = "The area of the country", example = "93028.0")
    private Float area;

    @Column(length = 100)
    @Schema(description = "The flag of the country", example = "https://flagcdn.com/hu.svg")
    private String flag;

    @CreationTimestamp
    @Column(nullable = false)
    private Date createDate;

    @UpdateTimestamp
    @Column(nullable = false)
    private Date updateDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return name.equals(country.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
