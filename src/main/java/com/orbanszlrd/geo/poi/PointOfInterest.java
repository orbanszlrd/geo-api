package com.orbanszlrd.geo.poi;

import com.orbanszlrd.geo.country.Country;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PointOfInterest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 2, max = 255)
    @Column(unique = true, nullable = false, length = 255)
    private String name;

    @NotNull
    private PoiType type;

    @ManyToOne(fetch = FetchType.EAGER)
    @NotNull
    private Country country;

    private Float latitude;

    private Float longitude;

    private Float altitude;

    @CreationTimestamp
    @Column(nullable = false)
    private Date createDate;

    @UpdateTimestamp
    @Column(nullable = false)
    private Date updateDate;

    public PointOfInterest(String name, PoiType type, Country country) {
        this.name = name;
        this.type = type;
        this.country = country;
    }

    public void setCountry(Country country) {
        this.country = country;
        country.addPointOfInterest(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PointOfInterest that = (PointOfInterest) o;
        return name.equals(that.name) && country.equals(that.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, country.getName());
    }

    @Override
    public String toString() {
        return name + " (" + country + ")";
    }
}
