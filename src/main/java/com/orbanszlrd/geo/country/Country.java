package com.orbanszlrd.geo.country;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.orbanszlrd.geo.poi.PointOfInterest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 2, max = 100)
    @Column(unique = true, nullable = false, length = 100)
    private String name;

    @Size(min = 2, max = 2)
    @Column(unique = true, nullable = false, length = 2)
    private String alpha2Code;

    @Size(min = 3, max = 3)
    @Column(unique = true, nullable = false, length = 3)
    private String alpha3Code;

    @Column(length = 100)
    private String capital;

    @Column(nullable = false, length = 100)
    private String subregion;

    @Column(nullable = false, length = 100)
    private String region;

    private Long population;

    private Float area;

    @Column(length = 100)
    private String flag;

    @CreationTimestamp
    @Column(nullable = false)
    private Date createDate;

    @UpdateTimestamp
    @Column(nullable = false)
    private Date updateDate;

    @JsonIgnore
    @OneToMany(mappedBy = "country", fetch = FetchType.LAZY)
    private Set<PointOfInterest> pointsOfInterest = new HashSet<>();

    public Country(String name) {
        this.name = name;
    }

    public void addPointOfInterest(PointOfInterest pointOfInterest) {
        pointsOfInterest.add(pointOfInterest);
    }

    public void removePointOfInterest(PointOfInterest pointOfInterest) {
        pointsOfInterest.add(pointOfInterest);
    }

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
