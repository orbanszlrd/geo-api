package com.orbanszlrd.geo.country;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

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

    @Column(unique = true, nullable = false, length = 2)
    private String alpha2Code;

    @Column(unique = true, nullable = false, length = 3)
    private String alpha3Code;

    @Column(unique = true, nullable = false, length = 100)
    @Schema(description = "The capital city of the country", example = "Budapest")
    private String capital;

    @Column(nullable = false, length = 100)
    @Schema(description = "The subregion of the country")
    private String subregion;

    @Column(nullable = false, length = 100)
    @Schema(description = "The region of the country")
    private String region;

    @Schema(description = "The population of the country")
    private Long population;

    @Schema(description = "The area of the country")
    private Float area;

    @Column(length = 100)
    @Schema(description = "The flag of the country")
    private String flag;

    @CreatedDate
    private Date createDate;

    @UpdateTimestamp
    private Date updateTimestamp;
}
