package com.orbanszlrd.geo.poi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PointOfInterestRepository extends JpaRepository<PointOfInterest, Long> {
}
